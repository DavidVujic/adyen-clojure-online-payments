(ns adyen.backend.app.components.adyen.client
  (:import (com.adyen Client)
           (com.adyen.enums Environment)))

(defn ->environment [api-env]
  (if (= api-env "test") Environment/TEST ""))

(defn create [{:keys [api-env api-token]}]
  (Client. api-token (->environment api-env)))
