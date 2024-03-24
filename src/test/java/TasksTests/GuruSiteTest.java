package TasksTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import java.util.List;
import static base.BrowserDriverFactory.closeBrowser;
import static pages.BasePageObjects.openUrl;
import static pages.ConstantPage.GuruSiteUrl;
import static pages.Guru99SitePage.getDropdownItemsContainingText;
import static pages.Guru99SitePage.selectFromMenu;

public class GuruSiteTest {

    //this is another bonus test i did
    @Epic("Guru99 Site Functionality Testing")
    @Feature("check sub menu drop down Values")
    @Description("check if a sub menu has relate text name like the main button from the main menu")
    @Test(groups = {"sanity"})
    public void menuDropdownTest() {
        openUrl(GuruSiteUrl);
        List<String> menuWithDropdown = getDropdownItemsContainingText("Selenium");
        if (!menuWithDropdown.isEmpty()) {
            System.out.println("Menu items with 'Selenium' found in the dropdown are:");
            for (String menuItem : menuWithDropdown) {
                System.out.println("- " + menuItem);
            }
        } else {
            System.out.println("No dropdown items with 'Selenium' found in the menu.");
        }
        closeBrowser();
    }

    //this test is more relate to task two instruction after lital email clarification
    @Description("check if an option from the main menu has a sub menu it will click on one of sub menu options")
    @Test(groups = {"sanity"})
    public void testSelectTopAndSubMenu() {
        openUrl(GuruSiteUrl);
        selectFromMenu( "Table Demo");
        closeBrowser();
    }
}