(defproject pitch-perfect-router "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.cli "0.2.4"]
                 [org.clojure/data.json "0.2.5"]
                 [pitch-perfect-core "0.1.3-SNAPSHOT"]
                 [ring "1.3.1"]]
  :aot :all
  :main pitch-perfect-router.core
  :jar-name "pitch-perfect-router.jar"
  :uberjar-name "pitch-perfect-router-standalone.jar"
  :repositories [["snapshots" {:url "s3p://221b/snapshots"
                               :passphrase :env
                               :username :env}]
                 ["releases" {:url "s3p://221b/releases"
                              :passphrase :env
                              :username :env}]]
  :plugins [[s3-wagon-private "1.1.2"]])
