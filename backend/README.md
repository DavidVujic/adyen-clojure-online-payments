# Clojure and Adyen

## An example API backend, using the Adyen Java SDK.
The Java code is wrapped in a custom `adyen` component.

Example usage, creating a payment session:

``` clojure
(session/create! {:amount 10 :currency "EUR" :payment-reference "My payment reference"} api-config)
```

### What's in it?
Http server with some routing basics, using `pedestal`.
Calling the Adyen test environment, to get a payment session.

Expecting to have a `env.edn` with configuration:

``` clojure
{:merchant     "<merchant>"
 :api-token    "<api-token>"
 :client-key   "<client-key>"
 :return-url   "<return url>"
 :country-code "<country code>"
 :environment  "test"}
```

The values needed for this config can be created and found in the Adyen Customer Area.

### What's missing?
There is no auth or header validation. All incoming traffic is allowed.
Currently, accepting a web app client running on localhost:8080 (CORS).

There is no `Webhook` added in this service (yet).

### Development
Start the backend app with:

``` shell
clojure -X adyen.backend.app.core/-main
```

Example cURL:
``` shell
curl -X POST -i http://localhost:8090/session -H 'Content-Type: application/json' -d '{"amount": 1000, "currency": "EUR", "reference": "HELLOWORLD"}'
```
