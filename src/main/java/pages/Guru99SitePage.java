package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import static locators.GuruSiteLocators.*;

public class Guru99SitePage extends BasePageObjects {

    @Step("get the drop down button text values which has relate text name to main menu text button and return them")
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

    @Step(" select option from sub menu if exciting")
    public static void selectFromMenu(String subMenu) {
        click(seleniumTabButton);
        if (subMenu != null && !subMenu.isEmpty()) {
            click(tableDemoOption);
        }
    }
}