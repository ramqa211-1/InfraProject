package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import java.util.List;
import static locators.TableSiteLocators.tableBody;
import static locators.TableSiteLocators.tableRaw;

public class TablePage extends BasePageObjects {

    @Step("Get Table Cell Text")
    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        List<WebElement> rows = table.findElements(tableBody);
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(tableRaw);
            if (!cells.isEmpty() && cells.size() > searchColumn) {
                String currentCellText = cells.get(searchColumn).getText();
                if (searchText.equals(currentCellText) && cells.size() > returnColumnText) {
                    return cells.get(returnColumnText).getText();
                }
            }
        }

        return null;
    }

    @Step("Verify Table Cell with Text")
    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        String actualText = getTableCellText(table, searchColumn, searchText, returnColumnText);
        if (expectedText.equals(actualText)) {
            return true;
        } else {
            return false;
        }
    }

    @Step("get country value with company name")
    public String getCountryForCompany(WebElement tableElement, String companyName) {
        List<WebElement> rows = tableElement.findElements(tableBody);
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(tableRaw);
            if (!cells.isEmpty()) {
                WebElement companyCell = cells.get(0);
                if (companyName.equals(companyCell.getText())) {
                    WebElement countryCell = cells.get(2);
                    return countryCell.getText();
                }
            }
        }
        return null;
    }
}