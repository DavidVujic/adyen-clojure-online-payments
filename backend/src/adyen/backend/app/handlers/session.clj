(ns adyen.backend.app.handlers.session
  (:require [adyen.backend.app.components.config.core :as config]
            [adyen.backend.app.components.adyen.session :as session]))

(defn create-session [{:keys [amount currency reference]} options]
  (session/create! {:amount            amount
                    :currency          currency
                    :payment-reference reference}
                   options))

(defn handler [{:keys [json-params]}]
  (let [response (create-session json-params config/options)]
    {:status 200 :body (select-keys response [:id :sessionData])}))

