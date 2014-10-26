(ns pitch-perfect-router.core
  (:require [clojure.tools.cli :as c]
            [clojure.data.json :as json]
            [pitch-perfect-core.events :refer [create-and-post]]
            [ring.util.codec :refer :all])
  (:gen-class))

;; {ToCountry US, NumMedia 0, ToState SC, FromZip 29209, ToCity , Body Test, SmsSid SMe96074ea1448df56d0bd526f13df7222, AccountSid ACfa4cb64673612f0fdbc16122eec3fa55, SmsStatus received, To +18036023046, FromState SC, ToZip , SmsMessageSid SMe96074ea1448df56d0bd526f13df7222, MessageSid SMe96074ea1448df56d0bd526f13df7222, FromCountry US, From +18037385811, ApiVersion 2010-04-01, FromCity COLUMBIA}
;; context subject predicate object

(defn submit
  [m]
  (create-and-post m
                   (get m "From")
                   "texted"
                   (get m "Body")))

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
      submit))

(defn -main
  "The application's main function"
  [& args]
  (let [[options args banner] (c/cli args
                                     ["-payload" "Payload to work on"]
                                     ["-d" "Something ironworker sticks in"]
                                     ["-id" "Something ironworker sticks in"]
                                     ["-e" "Something ironworker sticks in"]
                                     ["-config" "Something ironworker sticks in"]
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
    (println (:panyload options))
    (process (:payload options))))
