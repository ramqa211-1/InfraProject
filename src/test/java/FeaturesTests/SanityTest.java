package FeaturesTests;
import base.BrowserDriverFactory;
import locators.FeatureLocators;
import org.testng.annotations.Test;
import pages.BasePageObjects;
import pages.ConstantPage;


public class SanityTest extends BasePageObjects {
    ConstantPage constantPage = new ConstantPage();
    FeatureLocators featureLocators =new FeatureLocators();

    @Test(groups = {"sanity"})
    public void openHomePageAndViewPages() {
        openUrl(constantPage.featureUrl);
        click(featureLocators.arrowRightButton);
        click(featureLocators.arrowLeftButton);
        BrowserDriverFactory.closeBrowser();

    }
}