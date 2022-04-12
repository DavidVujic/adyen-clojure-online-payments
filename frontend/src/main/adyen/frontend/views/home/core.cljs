(ns adyen.frontend.views.home.core
  (:require [adyen.frontend.views.home.events]
            [adyen.frontend.views.home.subs]))

(defn header []
  [:<>
   [:h1 "ClojureScript and Adyen"]
   [:p "This is an example web app using the Dropin UI."]])

(defn drop-in-container []
  [:div#dropin-container])

(defn view []
  [:article
   [:section
    [header]]

   [:section {:style {:max-width 600}}
    [drop-in-container]]])
