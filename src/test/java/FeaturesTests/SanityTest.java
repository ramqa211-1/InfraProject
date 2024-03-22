package FeaturesTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePageObjects;
import pages.ConstantPage;
import pages.TablePage;


import static locators.FeatureLocators.customers;
import static pages.ConstantPage.AlfredsCompany;
import static pages.ConstantPage.CentroCompany;

public class
SanityTest extends BasePageObjects {
    ConstantPage constantPage = new ConstantPage();

    @Epic("Table Functionality Testing")
    @Feature("Table Values Check ")
    @Test(groups = {"sanity"})
    @Story("open site with table to check")
    @Description("Test Description: open table site and verify some parameters")
    public void openPageTableAndCheckGermanyCountry() {
        openUrl(constantPage.featureUrl);
        WebElement tableElement = driver.findElement(customers);
        TablePage tablePage = new TablePage();
        String country = tablePage.getCountryForCompany(tableElement, AlfredsCompany);
        if (country != null) {
            System.out.println("Country name is : " + country);
        } else {
            System.out.println("Company not found.");
        }
        String expectedCountry = "Germany";
        boolean verificationResult = tablePage.verifyTableCellText(tableElement, 0, AlfredsCompany, 2, expectedCountry);

        if (verificationResult) {
            System.out.println("Verification Passed: The country of " + AlfredsCompany + " is correctly listed as " + expectedCountry + ".");
            Assert.assertTrue(true, "Verification Passed: The country of " + AlfredsCompany + " is correctly listed as " + expectedCountry + ".");

        } else {
            System.out.println("Verification Failed: The country of " + AlfredsCompany + " is not listed as " + expectedCountry + ".");
            Assert.fail("Verification Failed: The country of " + AlfredsCompany + " is not listed as " + expectedCountry + ".");
        }
        closeBrowser();
    }

    @Test(groups = {"sanity"})
    public void openPageTableAndCheckMexicoCountry() {
        openUrl(constantPage.featureUrl);
        WebElement tableElement = driver.findElement(customers);
        TablePage tablePage = new TablePage();
        String country = tablePage.getCountryForCompany(tableElement, CentroCompany);
        if (country != null) {
            System.out.println("Country name is : " + country);
        } else {
            System.out.println("Company not found.");
        }

        String expectedCountry = "Mexico";
        boolean verificationResult = tablePage.verifyTableCellText(tableElement, 0, CentroCompany, 2, expectedCountry);
        if (verificationResult) {
            System.out.println("Verification Passed: The country of " + CentroCompany + " is correctly listed as " + expectedCountry + ".");
            Assert.assertTrue(true, "Verification Passed: The country of " + CentroCompany + " is correctly listed as " + expectedCountry + ".");
        } else {
            System.out.println("Verification Failed: The country of " + CentroCompany + " is not listed as " + expectedCountry + ".");
            Assert.fail("Verification Failed: The country of " + CentroCompany + " is not listed as " + expectedCountry + ".");
        }
        closeBrowser();
    }

}