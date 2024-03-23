package locators;
import org.openqa.selenium.By;

public class TableSiteLocators {
    public static By customers = By.id("customers");
    public static By tableBody = By.xpath(".//tbody/tr");
    public static By tableRaw = By.tagName("td");
}