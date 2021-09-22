$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("shopping.feature");
formatter.feature({
  "line": 1,
  "name": "Add four different products to the wish list and add lowest price item to the cart",
  "description": "",
  "id": "add-four-different-products-to-the-wish-list-and-add-lowest-price-item-to-the-cart",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Add four different products to the wish list and add lowest price item to the cart",
  "description": "",
  "id": "add-four-different-products-to-the-wish-list-and-add-lowest-price-item-to-the-cart;add-four-different-products-to-the-wish-list-and-add-lowest-price-item-to-the-cart",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I add four different product to my wishlist",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I view my wishlist table",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I find total four selected item in my Wishlist",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I search for lowest price product",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I am able to add my lowest price item to my cart",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I am able to verify the item in my cart",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.addFourDifferentProduct()"
});
formatter.result({
  "duration": 10794490716,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.viewMyWishListTable()"
});
formatter.result({
  "duration": 4574762771,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.findFourSelectedItemInWishLiST()"
});
formatter.result({
  "duration": 4033717680,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.searchLowestPriceItem()"
});
formatter.result({
  "duration": 228803404,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.addLowestItemToCart()"
});
formatter.result({
  "duration": 3155858487,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.verifyItemInCart()"
});
formatter.result({
  "duration": 3709883041,
  "status": "passed"
});
});