{:provided {:dependencies [[org.clojure/clojure "1.4.0"]
                           [com.palletops/pallet "0.8.0-RC.11"]]}
 :dev {:dependencies
       [[com.palletops/pallet "0.8.0-RC.11" :classifier "tests"]
        [ch.qos.logback/logback-classic "1.0.9"]
        [com.palletops/java-crate "0.8.0-beta.6"]]
       :plugins [[lein-set-version "0.3.0"]
                 [com.palletops/lein-pallet-crate "0.1.0"]
                 [lein-resource "0.3.2"]
                 [lein-pallet-release "RELEASE"]]
       :aliases {"live-test-up"
                 ["pallet" "up" "--phases" "settings,configure,test"]
                 "live-test-down" ["pallet" "down"]
                 "live-test" ["do" "live-test-up," "live-test-down"]}}
 :latest {:dependencies
          [[com.palletops/crates "0.8.0-SNAPSHOT"]
           [com.palletops/pallet "0.8.0-SNAPSHOT" :classifier "tests"]]}
 :doc {:dependencies [[codox-md "0.2.0"]]
       :codox {:writer codox-md.writer/write-docs
               :output-dir "doc/0.8/api"
               :src-dir-uri "https://github.com/pallet/java-crate/blob/develop"
               :src-linenum-anchor-prefix "L"}
       :aliases {"marg" ["marg" "-d" "doc/0.8/annotated/"]
                 "codox" ["doc"]
                 "doc" ["do" "codox," "marg"]}}
 :pallet {:source-paths ["src" "test"]
          :dependencies
          [[com.palletops/crates "0.8.0-SNAPSHOT"]
           [com.palletops/pallet "0.8.0-SNAPSHOT"]
           [com.palletops/pallet "0.8.0-SNAPSHOT" :classifier "tests"]]}
 :release
 {:set-version
  {:updates [{:path "README.md" :no-snapshot true}]}}}
