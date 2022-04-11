(ns adyen.backend.app.routing
  (:require [adyen.backend.app.handlers.ping :as ping]
            [adyen.backend.app.handlers.session :as session]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route :as route]))

(def routes
  (route/expand-routes
   #{["/ping" :get ping/handler :route-name :ping]
     ["/session" :post [(body-params/body-params) session/handler] :route-name :session]}))
