# Xpresscart

Built at PennApps XIII. Winner of the Capital One Nessie API Prize. Check out the project on Devpost: http://devpost.com/software/xpresscart-ypct9e

##Inspiration
The long checkout lines have made shopping a time-consuming chore for so many people that stores are losing about 5 million dollars of revenue because of this. Meanwhile, stores must expend large amounts of money to hire staff to run the checkout counters.

People despise waiting in lines, especially when they have 3 items and are stuck behind someone with 30. Xpresscart lets the user take the process into their own hands and makes the transaction seamless.

We aim to revolutionize the shopping experience as a whole - by making shopping more efficient and personalized, XpressCart not only boosts revenues but also cuts labor costs.

##What it does
XpressCart seeks to change the in-store shopping experience by moving the checkout counter into individual shopping carts. It keeps track of what the shopper has already bought and allows he/she to finish payment directly on the cart without having to wait in lines.

1) The shopper tags their phone to the NFC chip implanted on the cart. The phone reads the cart data and sends the data into the cloud, binding them with their cart and their purchases. All their data is available to the merchant and they will not be able to get a cart without the NFC companion and they will not be able to leave until they either cancel or confirm a purchase and return the cart.

2) As the shopper move through the store and select items, he/she would scan each item before placing it into the cart. The shopping list would get updated and they can place the item into the cart. If the shopper decides that he/she no longer want one of the items in the cart, the shopper can simply remove it using the quantity setter.

3) When the shopper is ready to pay, he/she can finish payment on the app since it is connected to their Capital One accounts via the Nessie API. The app sends a Purchase to Nessie and handles the transfer of funds from customer to Merchant.

The goal is that the entire shopping process can be performed without any staff assistance. XpressCart would not only attract customers to supermarkets by speeding up the shopping process, but would also be beneficial to store owners by cutting labor costs.

##How we built it
We log in our account (now implemented with nessie) on the phone app. Then we tap the phone on the NFC tag on the cart, which will trigger it's unlock. Afterwards, we can scan new items with the phone camera while shopping, and keep track of what we've bought on the screen.

##Challenges we ran into
We had no experience of working with log-in landing pages in an app before, so this time we spent a lot of efforts trying to realize that, so we can simulate the payment process.

We tried to add a scale which will physically keep track of the cart content, and compare that what's scanned and registered in the app so it can prevent shoplifting. The scale data has been transmitted to the phone through NFC, but we still need to work on how to coordinate that data in the app.

The Nessie API was also something new to work with and we had to figure out the format of its calls to the server (with the help of the Capital One Engineers).

##Accomplishments that we're proud of
We have successfully implemented the nessie API in our project (We all love the neat log in window!) and actually can keep track of the virtual capital flow in our accounts! We have integrated the barcode scanning and NFC reading components in the app. We have also accomplished the communication between the phone and the micro-controller. These are brand new experiences to us, but we keep learning.

##What we learned
Integration among different apps. NFC communication between phones and micro-controllers.

##What's next for Xpresscart
We will add the weight scale module to the whole system so we can avoid shoplifting. We also need to finish the payment module. We will test the prototype in supermarkets after it's done.
