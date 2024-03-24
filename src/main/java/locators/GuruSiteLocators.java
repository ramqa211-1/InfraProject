package locators;

import org.openqa.selenium.By;

public class GuruSiteLocators {
    public static By seleniumTabButton = By.xpath("//a[@class='dropdown-toggle' and contains(text(), 'Selenium')]");
    public static By buttonContainSelenium = By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(), 'Selenium')]");
    public static By tableDemoOption = By.xpath(("//a[@href='../../test/table.html']"));
}