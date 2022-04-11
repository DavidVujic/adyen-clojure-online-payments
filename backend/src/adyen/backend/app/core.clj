(ns adyen.backend.app.core
  (:require [adyen.backend.app.routing :as routing]
            [io.pedestal.http :as http]))

(def service-map
  {::http/routes routing/routes
   ::http/type   :jetty
   ::http/port   8090})

(defn start [options]
  (http/start (http/create-server options)))

(defn -main [_]
  (start service-map))
