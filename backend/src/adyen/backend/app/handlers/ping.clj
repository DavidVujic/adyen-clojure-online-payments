(ns adyen.backend.app.handlers.ping
  (:require [clojure.data.json :as json]))

(defn handler [_request]
  {:status  200
   :body    (json/write-str {:data "PONG!"})
   :headers {"Content-Type" "application/json"}})
