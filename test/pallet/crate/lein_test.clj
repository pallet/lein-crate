(ns pallet.crate.lein-test
  (:require
   [clojure.test :refer :all]
   [pallet.action :refer [with-action-options]]
   [pallet.actions :refer [exec-checked-script remote-file]]
   [pallet.api :refer [plan-fn server-spec]]
   [pallet.build-actions :refer [build-actions]]
   [pallet.crate.lein :as lein]
   [pallet.crate.java :as java]
   [pallet.test-utils]))

(deftest install-lein-test
  (is (script-no-comment=
       (first (build-actions {:phase-context "install"}
                (remote-file
                 "/usr/local/bin/lein"
                 :url (format lein/*lein-url* "stable")
                 :insecure true
                 :no-versioning true
                 :mode "755")))
       (first  (build-actions {}
                 (lein/settings {})
                 (lein/install {}))))))

(deftest lein-test
  (is (script-no-comment=
       (first (build-actions {:phase-context "lein"}
                (exec-checked-script
                 "lein test"
                 ("/usr/local/bin/lein" test))))
       (first  (build-actions {}
                 (lein/settings {})
                 (lein/lein :test))))))

(deftest leiningen-test
  (is (lein/server-spec {})))

(def live-test-spec
  (server-spec
   :extends [(lein/server-spec {}) (java/server-spec {})]
   :phases {:test (plan-fn
                    (with-action-options {:script-prefix :no-sudo}
                      (lein/lein "version")))}))
