(ns adyen.frontend.views.home.events
  (:require [ajax.core :as ajax]
            [day8.re-frame.http-fx]
            [re-frame.core :as re-frame]
            ["@adyen/adyen-web" :as AdyenCheckout]))

(defn mount-checkout [checkout]
  (let [^js dropin (-> checkout (.create "dropin"))]
    (-> dropin (.mount "#dropin-container"))))

(defn enable-checkout [config]
  (-> config
      clj->js
      AdyenCheckout
      (.then mount-checkout)))

(defn payment-completed [result component]
  (println "Completed: " result component))

(defn create-adyen-config [{:keys [id sessionData client-key environment]}]
  {:environment        environment
   :clientKey          client-key
   :session            {:id id :sessionData sessionData}
   :onPaymentCompleted payment-completed})

(re-frame/reg-fx
 :home/enable-checkout
 (fn [data]
   (-> data
       create-adyen-config
       enable-checkout)))

(re-frame/reg-event-fx
 :home/enable-checkout
 (fn [_ [_ data]]
   {:home/enable-checkout data}))

(re-frame/reg-event-db
 :home/add-session-data
 (fn [db [_ data]]
   (assoc-in db [:home :session-data] data)))

(re-frame/reg-event-db
 :home/fail
 (fn [_ [_ data]]
   (println "Failed: " data)))

(re-frame/reg-event-fx
 :home/success
 (fn [_ [_ data]]
   {:fx [[:dispatch-n (list [:home/add-session-data data]
                            [:home/enable-checkout data])]]}))

(re-frame/reg-event-fx
 :home/fetch-session-data
 (fn [_ [_ data]]
   {:http-xhrio {:method          :post
                 :uri             "http://localhost:8090/session"
                 :params          data
                 :timeout         5000
                 :format          (ajax/json-request-format)
                 :response-format (ajax/json-response-format {:keywords? true})
                 :on-success      [:home/success]
                 :on-failure      [:home/fail]}}))

