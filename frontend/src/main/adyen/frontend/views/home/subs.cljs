(ns adyen.frontend.views.home.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :home/session-data
 (fn [db]
   (get-in db [:home :session-data])))

(re-frame/reg-sub
 :home/adyen-config
 (fn [db]
   (get-in db [:home :adyen-config])))

(comment
  @(re-frame/subscribe [:home/session-data])

  (clj->js @(re-frame/subscribe [:home/adyen-config])))
