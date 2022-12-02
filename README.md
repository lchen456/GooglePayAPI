# MiniResearchAPI
APP that implements GooglePay API

## Description
This is a simple app that explores how to use GooglePay API. This was created with the idea of a more complex theme store in mind. 
For simplicity's sake, we have decided to just implement one color (purple). However, the code can be applied to multiple other colors as well.
`Goal: the user can "buy" a color and apply that color to the app background`

## To Test
Please be logged into a google account that has been registered with google pay and has a payment method available!

## Setup
[Setup](https://developers.google.com/pay/api/android/guides/setup)
- minSdkVersion : 19 or higher
- compileSdkVersion : 28 or higher 
- in app/build.gradle (module) add the following dependency:
` dependencies { implementation 'com.google.android.gms:play-services-wallet:19.1.0'} `
- in the manifest file add the following metadata to `<application>`:
`<meta-data android:name="com.google.android.gms.wallet.api.enabled" android:value="true" />`

## Environment
There are two environments: test and production. For this app we are using the test environment which does not actually charge the payment method. `WalletConstants.ENVIRONMENT_TEST` 
For this assignment, we did not open our app to testers which would require us to publish the app to a test track-this is not particularly feasible given our time constraints/time is mainly spent working on our main app GiftMe!. (Note that publishing the app to a test track is a good idea down the line to allow users to install the app that is not yet publicly available.)


## Implementation
There are three main files:
1. Constants.java
2. PaymentsUtils.java  
3. CheckoutActivity.java

### Constants.java
This file defines the constants used in PaymentsUtils.java.
- CURRENCY_CODE `CURRENCY_CODE="USD`
- COUNTRY_CODE `COUNTRY_CODE="US`
- List of supported cards eg `DISCOVER, MASTERCARD, VISA`
- gateways/merchants - when using example gateway, card does not get charged (we left as example in this app)

### PaymentsUtils.java
This file contains the methods and helpers for getting payment requests. This is where information related to payments is defined.
- ` getBaseRequest() ` : declare version of Google Pay API
- ` getGatewayTokenizationSpecification()` : request payment token for payment provider
- ` getAllowedCardNetworks() ` : define card networks accepted by API, e.g. Discoveer, Mastercard, Visa etc
- ` getAllowedCardAuthMethods() ` : define what payment methods on file will be returned 
- ` getBaseCardPaymentMethod() ` : describes app's support for CARD payment method, returns a card payment method

### CheckoutActivity.java
This is where user activity happens! 
In the `onCreate` method, we initialize all the views, including the Google Pay button. Then we check if client isReadyToPay(). If so, the Google Pay Payment shows up. 
We have a boolean that checks if the purple theme is bought--and if it is then when the user presses 'use' the background will change to purple.

### Brand Guidelines
We need to use the branded Google Pay button. The Google Pay API page also talks about best practices for using Google Pay API such as having a confirmation screen, etc. We have decided to forego some of the screens.
Google Pay assets can be downloaded [here](https://developers.google.com/pay/api/android/guides/brand-guidelines).

### Resources
[Tutorial](https://developers.google.com/pay/api/web/guides/tutorial)
