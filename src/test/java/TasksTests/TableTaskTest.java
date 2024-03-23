package TasksTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePageObjects;
import pages.CompanyCountryEnum;
import pages.ConstantPage;
import pages.TablePage;


import static locators.TableSiteLocators.customers;


public class
TableTaskTest extends BasePageObjects {
    ConstantPage constantPage = new ConstantPage();

    @Epic("Table Functionality Testing")
    @Feature("Table Values Check")
    @Description("Checking all company name match to country value")
    @Test(groups = {"sanity"})
    public void openPageTableAndCheckCountries() {
        openUrl(constantPage.TableSiteUrl);
        WebElement tableElement = driver.findElement(customers);
        TablePage tablePage = new TablePage();
        for (CompanyCountryEnum companyCountryEnum : CompanyCountryEnum.values()) {
            String companyName = companyCountryEnum.getCompanyName();
            String expectedCountry = companyCountryEnum.getCountry();
            String actualCountry = tablePage.getCountryForCompany(tableElement, companyName);
            if (actualCountry != null) {
                System.out.println("Country name is : " + actualCountry);
            } else {
                System.out.println("Company not found.");
                continue;
            }
            boolean verificationResult = actualCountry.equals(expectedCountry);
            if (verificationResult) {
                System.out.println("Verification Passed: The country of " + companyName + " is correctly listed as " + expectedCountry + ".");
                Assert.assertTrue(verificationResult, "Verification Passed: The country of " + companyName + " is correctly listed as " + expectedCountry + ".");
            } else {
                System.out.println("Verification Failed: The country of " + companyName + " is not listed as " + expectedCountry + ".");
                Assert.fail("Verification Failed: The country of " + companyName + " is not listed as " + expectedCountry + ".");
            }
        }
        closeBrowser();
    }
}