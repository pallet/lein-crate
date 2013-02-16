;;; Pallet project configuration file

(require
 '[pallet.crate.lein-test :refer [live-test-spec]]
 '[pallet.crates.test-nodes :refer [node-specs]])

(defproject lein-crate
  :provider node-specs                  ; supported pallet nodes
  :groups [(group-spec "lein-live-test"
                       :extends [with-automated-admin-user
                                 live-test-spec])])
