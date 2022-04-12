(ns adyen.frontend.app
  (:require
   [adyen.frontend.components.navigation.core :as navigation]
   [adyen.frontend.routing :as routing]
   [adyen.frontend.views.notfound :as notfound]
   [reagent.dom :as rd]))

(defn main []
  [:<>
   [:nav
    [navigation/list-routes routing/routes]]

   (let [match @routing/match]
     (if match
       [(-> match :data :view)]
       [notfound/oh-no]))])

(defn start []
  (rd/render [main] (-> js/document (.getElementById "root"))))

(defn init []
  (routing/init!)

  (start))
