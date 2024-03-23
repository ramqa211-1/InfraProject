package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import static locators.GuruSiteLocators.buttonContainSelenium;
import static locators.GuruSiteLocators.seleniumTabButton;

public class Guru99SitePage extends BasePageObjects {


    @Step (" get the drop down button text values which has relate text name to main menu text button and return them")
    public static List<String> getDropdownItemsContainingText(String menuText) {
        List<String> matchingItems = new ArrayList<>();
        click(seleniumTabButton);
        List<WebElement> submenuItems = driver.findElements(buttonContainSelenium);
        for (WebElement item : submenuItems) {
            String itemText = item.getText();
            if (itemText.contains(menuText)) {
                matchingItems.add(itemText);
            }
        }
        return matchingItems;
    }
}
