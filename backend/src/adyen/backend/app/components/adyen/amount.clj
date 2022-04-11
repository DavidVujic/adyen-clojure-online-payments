(ns adyen.backend.app.components.adyen.amount
  (:import (com.adyen.model Amount)))

(defn create [value currency]
  (doto
   (Amount.)
    (.setCurrency currency)
    (.setValue (long value))))
