package FeaturesTests;
import base.BrowserDriverFactory;
import locators.FeatureLocators;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePageObjects;
import pages.ConstantPage;
import java.util.ArrayList;
import java.util.Arrays;

public class SanityTest extends BasePageObjects {
    ConstantPage constantPage = new ConstantPage();
    FeatureLocators featureLocators = new FeatureLocators();

    @Test(groups = {"sanity"})
    public void openHomePageAndViewPages() {
        openUrl(constantPage.featureUrl);
        click(featureLocators.arrowRightButton);
        click(featureLocators.arrowLeftButton);
        BrowserDriverFactory.closeBrowser();
    }

    @Test(groups = {"sanity"})
    public void createNewTile() {
        openUrl(constantPage.featureUrl);
        click(featureLocators.plusIconButton);
        click(featureLocators.nameField);
        typeText(featureLocators.nameField, "Criminals Last Names");
        click(featureLocators.colorDropDown);
        click(featureLocators.redColor);
        click(featureLocators.descriptionField);
        typeText(featureLocators.descriptionField, "All new criminal should add is Last Name");
        click(featureLocators.saveButton);
        BrowserDriverFactory.closeBrowser();
    }

    @Test(groups = {"sanity"})
    public void searchSpecificTiles() {
        ArrayList<String> searchTilesOptions = new ArrayList<>(Arrays.asList(
                "murder",
                "car accident",
                "human trafficking for prostitution",
                "suspect",
                "terrorism",
                "terrorist attack"
        ));

        openUrl(constantPage.featureUrl);
        for (String searchTerm : searchTilesOptions) {
            click(featureLocators.searchField);
            typeText(featureLocators.searchField, searchTerm);
            click(featureLocators.mirrorSearchIcon);
            String dashboardResultBody = getText(featureLocators.dashboardResultBody);
            Assert.assertEquals(dashboardResultBody, searchTerm, "Dashboard result body include match tile option on search body results : " + searchTerm);
            click(featureLocators.resetSearchResultsButton);
        }
        BrowserDriverFactory.closeBrowser();
    }
}