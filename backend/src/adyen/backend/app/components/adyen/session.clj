(ns adyen.backend.app.components.adyen.session
  (:require [adyen.backend.app.components.adyen.checkout :as checkout]
            [adyen.backend.app.components.adyen.client :as client]
            [adyen.backend.app.components.adyen.request :as request]))

(defn create! [session-data options]
  (let [adyen-client (client/create options)
        checkout     (checkout/create adyen-client)
        request      (request/create session-data options)]
    (-> checkout (.sessions request) bean)))
