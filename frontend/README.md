# ClojureScript and Adyen

## An example web app using the Dropin UI.

### What's in the frontend?
A single page web app, with routing support.

Using the `@adyen/adyen-web` npm package.

### What's not in the frontend?
Redirect support is not added. No auth at all. The URI to the backend is hard coded.

The `css` file(s) from the Adyen npm package is manually added to the public folder,
using:

``` shell
npm run copy-adyen-files
```

