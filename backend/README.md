Start the backend app with:

``` shell
clojure -X adyen.backend.app.core/-main
```

Example cURL:
``` shell
curl -X POST -i http://127.0.0.1:8090/session -H 'Content-Type: application/json' -d '{"amount": 1000, "currency": "EUR", "reference": "HELLOWORLD"}'
```
