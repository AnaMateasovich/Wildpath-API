package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageWildPathFullForm {

    private final WebDriver driver;

    public PageWildPathFullForm(WebDriver driver) {
        this.driver = driver;
    }

    // SELECCIONAR UNA EMPRESA
    public WebElement getButtonSelectEnterprise() {
        return driver.findElement(By.id("btnSelectEnterprise"));
    }

    public List<WebElement> getEnterprisesListItems() {
        return driver.findElements(By.id("enterprisesList"));
    }

    public void selectEnterpriseByName(String enterpriseName) {
        getButtonSelectEnterprise().click();

        List<WebElement> enterpriseOptions = getEnterprisesListItems();

        for (WebElement option : enterpriseOptions) {
            if (option.getText().equals(enterpriseName)) {
                option.click();
                break;
            }
        }

    }


    // ENTERPRISE
    public WebElement getEnterpriseNameInput() {
        return driver.findElement(By.id("enterpriseName"));
    }
    public WebElement getEnterpriseCuitInput() {
        return driver.findElement(By.id("enterpriseCuit"));
    }
    public WebElement getEnterpriseEmailInput() {
        return driver.findElement(By.id("enterpriseEmail"));
    }
    public WebElement getEnterprisePhoneInput() {
        return driver.findElement(By.id("enterprisePhone"));
    }
    public WebElement getEnterpriseAddress() {
        return driver.findElement(By.id("enterpriseAddress"));
    }
    public WebElement getEnterpriseSocialMediaInput() {
        return driver.findElement(By.id("enterpriseSocialMedia"));
    }
    public WebElement getEnterpriseDescriptionInput() {
        return driver.findElement(By.id("enterpriseDescription"));
    }

    // PACKAGE
    public WebElement getPackageNameInput() {
        return driver.findElement(By.id("packageName"));
    }

    public WebElement getPackageDescriptionInput() {
        return driver.findElement(By.id("packageDescription"));
    }
    public WebElement getPackageCategoryInput() {
        return driver.findElement(By.id("packageCategory"));
    }
    public WebElement getPackagePlaceInput() {
        return driver.findElement(By.id("packagePlace"));
    }
    public WebElement getPackageDurationDaysInput() {
        return driver.findElement(By.id("packageDurationDays"));
    }
    public WebElement getPackageDurationNightsInput() {
        return driver.findElement(By.id("packageDurationNights"));
    }
    public WebElement getPackageDurationHoursInput() {
        return driver.findElement(By.id("packageDurationHours"));
    }
    public WebElement getPackageDurationMinutesInput() {
        return driver.findElement(By.id("packageDurationMinutes"));
    }

    public WebElement getPackageInclude() {
        return driver.findElement(By.id("packageInclude"));
    }
    public WebElement getPackageIncludeIcon() {
        return driver.findElement(By.id("icon-packageInclude"));
    }
    public WebElement getPackageIncludeButton() {
        return driver.findElement(By.id("button-include"));
    }
    public WebElement getPackageLocation() {
        return driver.findElement(By.id("packageLocation"));
    }
    public WebElement getPackagePrice() {
        return driver.findElement(By.id("packagePrice"));
    }
    public WebElement getPackageDiscount() {
        return driver.findElement(By.id("packageDiscount"));
    }
    public WebElement getPackageDifficulty() {
        return driver.findElement(By.id("packageDifficulty"));
    }
    public WebElement getPackageCancelPolicy() {
        return driver.findElement(By.id("packageCancelPolicy"));
    }

    // IMAGES
    public WebElement getPackageImage() {
        return driver.findElement(By.id("loadImage"));
    }

    // DATES AVAILABLE
    public WebElement getDateAvailableDate() {
        return driver.findElement(By.id("dateAvailableDate"));
    }
    public WebElement getDateAvailableSpots() {
        return driver.findElement(By.id("dateAvailableSpots"));
    }
    public WebElement getDateAvailableButton() {
        return driver.findElement(By.id("dateAvailableButton"));
    }

    // MULTIPLE DATES
    public WebElement getDateAvailableRangeStart() {
        return driver.findElement(By.id("startRangeDate"));
    }
    public WebElement getDateAvailableRangeEnd() {
        return driver.findElement(By.id("endRangeDate"));
    }
    public WebElement getDateAvailableRangeSpots() {
        return driver.findElement(By.id("rangeSpots"));
    }
    public WebElement getDateAvailableRangeButtonGenerate() {
        return driver.findElement(By.id("generateDatesButton"));
    }
    public WebElement getDateAvailableDayOfWeek() {
        return driver.findElement(By.id("day-5"));
    }
    public WebElement getDateAvailableAddRangeButton() {
        return driver.findElement(By.id("addRangeDatesButton"));
    }


    // REQUIREMENTS
    public WebElement getPackageRequirementTitle() {
        return driver.findElement(By.id("packageRequirementTitle"));
    }
    public WebElement getPackageRequirementDescription() {
        return driver.findElement(By.id("packageRequirementDescription"));
    }
    public WebElement getPackageRequirementButton() {
        return driver.findElement(By.id("packageRequirementButton"));
    }

    // NEXT
    public WebElement getNextButton() {
        return driver.findElement(By.id("nextButton"));
    }

    //ENVIAR
    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submitFullForm"));
    }

}
