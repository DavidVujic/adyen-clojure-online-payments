Start the backend app with:

``` shell
clojure -X adyen.backend.app.core/-main
```

Example cURL:
``` shell
curl -X POST -i http://localhost:8090/session -H 'Content-Type: application/json' -d '{"amount": 1000, "currency": "EUR", "reference": "HELLOWORLD"}'
```
