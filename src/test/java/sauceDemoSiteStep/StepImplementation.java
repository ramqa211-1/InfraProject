package sauceDemoSiteStep;
import base.BrowserDriverFactory;
import pages.ConstantPage;
import static pages.BasePageObjects.*;
import static locators.SiteLocators.*;


public class StepImplementation {
    ConstantPage constantPage = new ConstantPage();

    public void openSauceDemoWebsite(String url) {
        openUrl(url);
    }

    public void loginToSauceDemo() {
        click(userNameField);
        typeText(userNameField, constantPage.userNameField);
        click(passwordField);
        typeText(passwordField, constantPage.passwordField);
        click(loginButton);
    }

    public void addProductsToCart() {
        click(addToCartBikeLightButton);
        click(addToCartOnesieButton);
    }

    public void goToShoppingCart() {
        click(cartButton);
    }

    public void clickOnCheckoutButton() {
        click(checkoutButton);
    }

    public void fillInDetailsOnCheckOutPage(String name, String address, String zip) {
        click(firstNameField);
        typeText(firstNameField, name);
        click(lastNameField);
        typeText(lastNameField, address);
        click(postalCodeField);
        typeText(postalCodeField, zip);
    }

    public void clickOnContinueButton() {
        click(continueButton);
    }



    public static void closeBrowser() {
        BrowserDriverFactory.closeBrowser();
    }
}