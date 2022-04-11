(ns adyen.backend.app.dev
  (:require [adyen.backend.app.core :as core]
            [io.pedestal.http :as http]))

(defonce server (atom nil))

(defn start-dev []
  (reset! server (core/start (assoc core/service-map ::http/join? false))))

(defn stop-dev []
  (when @server
    (http/stop @server)))

(defn restart []
  (stop-dev)
  (start-dev))

(comment
  (restart))
