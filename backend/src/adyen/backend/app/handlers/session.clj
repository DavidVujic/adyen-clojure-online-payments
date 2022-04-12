(ns adyen.backend.app.handlers.session
  (:require [clojure.data.json :as json]
            [adyen.backend.app.components.config.core :as config]
            [adyen.backend.app.components.adyen.session :as session]))

(defn create-session [{:keys [amount currency reference]} options]
  (session/create! {:amount            amount
                    :currency          currency
                    :payment-reference reference}
                   options))

(defn pick-relevant-data [response options]
  (merge
   (select-keys response [:id :sessionData])
   (select-keys options [:client-key :environment])))

(defn handler [{:keys [json-params]}]
  (let [options  (config/from-file)
        response (create-session json-params options)]
    {:status  200
     :body    (-> response
                  (pick-relevant-data options)
                  json/write-str)
     :headers {"Content-Type" "application/json"}}))
