(ns adyen.frontend.views.home.core
  (:require [adyen.frontend.views.home.events]
            [adyen.frontend.views.home.subs]
            [re-frame.core :as re-frame]))

(defn header []
  [:<>
   [:h1 "Hello World"]
   [:p "Yes, this is the Home view."]])

(defn server-response-data []
  (let [data @(re-frame/subscribe [:home/session-data])]
    (when data
      [:<>
       [:p [:strong "Got this from the server:"]]
       [:pre (str data)]])))

(defn drop-in-container []
  [:div#dropin-container])

(defn view []
  [:article
   [:section
    [header]]

   [:section
    [server-response-data]]

   [:section {:style {:width 400}}
    [drop-in-container]]])
