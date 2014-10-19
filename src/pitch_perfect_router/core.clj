(ns pitch-perfect-router.core
  (:require [clojure.tools.cli :as c]
            [clojure.data.json :as json]
            [ring.util.codec :refer :all])
  (:gen-class))

(defn query-string-to-map
  [query-string]
  (->> (clojure.string/split query-string #"&")
       (map #(clojure.string/split % #"="))
       (map (fn [[k v]] [(keyword k) v]))
       (into {})))

(defn process
  "I don't do a whole lot."
  [file-name]
  (-> file-name
      slurp
      form-decode
      println))

(defn -main
  "The application's main function"
  [& args]
  (let [[options args banner] (c/cli args
                                     ["-payload" "Payload to work on"]
                                     ["-d" "Something ironworker sticks in"]
                                     ["-id" "Something ironworker sticks in"]
                                     ["-e" "Something ironworker sticks in"]
                                     ["-f" "Something ironworker sticks in"]
                                     ["-g" "Something ironworker sticks in"]
                                     ["-h" "Something ironworker sticks in"]
                                     ["-i" "Something ironworker sticks in"]
                                     ["-j" "Something ironworker sticks in"]
                                     ["-k" "Something ironworker sticks in"]
                                     ["-l" "Something ironworker sticks in"]
                                     ["-m" "Something ironworker sticks in"]
                                     ["-n" "Something ironworker sticks in"]
                                     ["-o" "Something ironworker sticks in"]
                                     ["-p" "Something ironworker sticks in"]
                                     ["-q" "Something ironworker sticks in"]
                                     ["-r" "Something ironworker sticks in"]
                                     ["-s" "Something ironworker sticks in"]
                                     ["-t" "Something ironworker sticks in"]
                                     ["-u" "Something ironworker sticks in"]
                                     ["-v" "Something ironworker sticks in"]
                                     ["-x" "Something ironworker sticks in"]
                                     ["-y" "Something ironworker sticks in"])]
    (println (pr-str options))
    (println (:payload options))
    (process (:payload options))))
