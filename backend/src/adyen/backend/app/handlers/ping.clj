(ns adyen.backend.app.handlers.ping)

(defn handler [_request]
  {:status 200 :body "pong!"})
