(ns pallet.crate.lein
  "Crate to install leiningen"
  (:require
   [clojure.string :as string]
   [clojure.tools.logging :refer [debugf]])
  (:use
   [pallet.action :only [with-action-options]]
   [pallet.actions :only [exec-checked-script remote-file]]
   [pallet.api :only [plan-fn server-spec]]
   [pallet.crate :only [defplan get-settings assoc-settings]]))

(def ^{:dynamic true} *default-settings*
  {:dir "/usr/local/bin/"
   :version "stable"
   :exec-name "lein"})

(def ^{:dynamic true} *lein-url*
  "https://raw.github.com/technomancy/leiningen/%s/bin/lein")

(defplan lein-settings
  "Set options for lein install.

   `version` is the version of lein to install. Can be any branch or tagname in
   github.com/techomancy/leiningen. Defaults to 'preview'.

   If not specified, `dir` defaults to /usr/local/bin."
  [{:keys [dir exec-name instance-id version] :as settings}]
  (assoc-settings
   :lein (merge *default-settings* settings) {:instance-id instance-id}))

(defn- install-path
  [settings]
  (str (:dir settings) (:exec-name settings)))

(defplan install-lein
  "Install lein script."
  [& {:keys [instance-id]}]
  (let [settings (get-settings :lein {:instance-id instance-id})]
    (remote-file
     (install-path settings)
     :url (format *lein-url* (:version settings))
     :insecure true
     :no-versioning true
     :mode "755")))

(defplan lein
  "Calls a lein task. All arguments are passed to lein.

   `options` specifies options for retrieving settings."
  {:arglists '((options? & args))}
  [& args]
  (let [options (or (first (filter map? args)) {})
        args (remove map? args)
        settings (get-settings :lein options)]
    (debugf "lein %s" (string/join " " (seq args)))
    (exec-checked-script
     (str "lein " (string/join " " (map name args)))
     (~(install-path settings)
      ~(string/join " " (map name (remove map? args)))))))

(defn leiningen
  [settings]
  (server-spec
   :phases {:settings (plan-fn (lein-settings settings))
            :configure (plan-fn (install-lein))}))
