(ns adyen.backend.app.components.config.core
  (:require [clojure.edn :as edn]))

;; Expecting a config file with necessary data:
;;  {:merchant     "<Merchant>"
;;   :api-token    "<api-token>"
;;   :client-key   "<client-key>"
;;   :return-url   "<return url>"
;;   :country-code "<country code>"
;;   :environment  "test"}

(def secrets-file "env.edn")

(defn from-file []
  (try
    (edn/read-string (slurp secrets-file))
    (catch java.io.FileNotFoundException e
      (println e))))
