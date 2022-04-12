(ns adyen.backend.app.components.adyen.client
  (:import (com.adyen Client)
           (com.adyen.enums Environment)))

(defn ->environment [environment]
  (if (= environment "test") Environment/TEST "<Insert something here>"))

(defn create [{:keys [environment api-token]}]
  (Client. api-token (->environment environment)))
