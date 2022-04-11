(ns adyen.backend.app.components.adyen.request
  (:require [adyen.backend.app.components.adyen.amount :as amount])
  (:import (com.adyen.model.checkout CreateCheckoutSessionRequest)))

(defn create [{:keys [amount currency payment-reference]} {:keys [merchant return-url country-code]}]
  (doto
   (CreateCheckoutSessionRequest.)
    (.setAmount (amount/create amount currency))
    (.setMerchantAccount merchant)
    (.setReturnUrl return-url)
    (.setReference payment-reference)
    (.setCountryCode country-code)))
