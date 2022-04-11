(ns adyen.frontend.components.navigation.core
  (:require [reitit.frontend.easy :as rfe]))

(defn link [{:keys [name text]}]
  [:a {:href (rfe/href name)} text])

(defn list-routes [routes]
  [:ul
   (for [[path data] routes]
     ^{:key path} [:li [link data]])])
