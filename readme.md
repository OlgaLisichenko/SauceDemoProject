# [SauceDemo](https://www.saucedemo.com/) is a sample website built by SauceLabs that allows users to practice browser automation
## The following has been applied in this project:
1. Selenium
2. TestNG with Retry, TestListener, Data Provider and running in parallel
3. Maven
4. Allure reporting
5. Logging
***
## *Checklist*
1. ***Login page***
    1. Checking the authorization of a registered user;
    2. Verification of authorization with an empty "Password" field;
    3. Verification of authorization with invalid username and password;
    4. Verification of authorization with an empty "Username" field;
    5. Checking the authorization of a blocked user("locked_out_user");
    6. Authorization verification "performance_glitch_user".
***
2. ***Side menu***
    1. Checking the link Logout.
***
3. ***Products page***
    1. Checking the correctness of sorting by dropdown values.
***
4. ***Cart page***
    1. Checking the button "Continue Shopping";
    2. Checking the button "Checkout";
    3. Checking the possibility of adding an item to the cart and deleting it.
***   
5. ***Checkout page***
    1. Checking the button "Cancel";
    2. Checking the button "Continue";
    3. Checking the link "Cart";
    4. Checking for pressing the "Continue" button when the "Zip/Postal Code" field is empty.
