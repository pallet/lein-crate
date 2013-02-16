;;; Pallet project configuration file

(require '[pallet.crate.lein-test :refer [live-test-spec]])

(defproject lein-crate
  :provider {:vmfest
             {:node-spec
              {:image {:os-family :ubuntu :os-version-matches "12.04"
                       :os-64-bit true}}
              :selectors #{:default}}}

  :groups [(group-spec "lein-live-test" :extends [live-test-spec])])
