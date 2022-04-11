(ns adyen.backend.app.components.adyen.checkout
  (:import (com.adyen Client)
           (com.adyen.service Checkout)))

(defn create [^Client client]
  (Checkout. client))
