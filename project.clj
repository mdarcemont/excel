(defproject example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2727"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.omcljs/om "0.8.7"]
                 [racehub/om-bootstrap "0.3.4"]]
  :plugins [[lein-cljsbuild "1.0.4"]
            [org.bodil/lein-noderepl "0.1.11"]]
  :source-paths ["src" "target/classes"]
  :cljsbuild {
  :builds [{:id "dev"
            :source-paths ["src"]
            :compiler {
              :main excel.core
              :output-to "main.js"
              :output-dir "out"
              :optimizations :none
              :source-map true}}]})
