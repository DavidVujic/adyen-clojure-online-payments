(ns adyen.frontend.routing
  (:require
   [adyen.frontend.views.home.core :as home]
   [reagent.core :as r]
   [reitit.coercion.spec :as rss]
   [reitit.frontend :as rf]
   [reitit.frontend.easy :as rfe]))

(def routes
  [["/"
    {:name        :home
     :view        home/view
     :text        "Home"
     :controllers [{:start (println "start" "Home")
                    :stop  (println "stop" "Home")}]}]])

(defonce match (r/atom nil))
(def router (rf/router routes {:data {:coercion rss/coercion}}))
(def on-navigate (fn [m] (reset! match m)))
(def opts {:use-fragment true})

(defn init! []
  (rfe/start! router on-navigate opts))
