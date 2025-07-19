package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageWildPathFullForm;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormSubmissionSteps {

    private WebDriver driver;
    private PageWildPathFullForm wildPathFullForm;

    @Given("el usuario completa el formulario de empresa y paquete")
    public void userFullFilledEnterpriseAndPackageForm() {
        driver = Fixtures.getDriver();
        wildPathFullForm = new PageWildPathFullForm(driver);

        driver.get("http://localhost:5173/admin/actividades/crear");

        // Completar datos de empresa

//        wildPathFullForm.getEnterpriseNameInput().sendKeys(TestData.ENTERPRISE_NAME);
//        wildPathFullForm.getEnterpriseCuitInput().sendKeys(TestData.ENTERPRISE_CUIT);
//        wildPathFullForm.getEnterpriseEmailInput().sendKeys(TestData.ENTERPRISE_EMAIL);
//        wildPathFullForm.getEnterprisePhoneInput().sendKeys(TestData.ENTERPRISE_PHONE);
//        wildPathFullForm.getEnterpriseAddress().sendKeys(TestData.ENTERPRISE_ADDRESS);
//        wildPathFullForm.getEnterpriseSocialMediaInput().sendKeys(TestData.ENTERPRISE_SOCIALMEDIA);
//        wildPathFullForm.getEnterpriseDescriptionInput().sendKeys(TestData.ENTERPRISE_DESCRIPTION);

       wildPathFullForm.selectEnterpriseByName(TestData.SELECTED_ENTERPRISE);

        // NEXT
        wildPathFullForm.getNextButton().click();

        // Completar datos del paquete
        wildPathFullForm.getPackageNameInput().sendKeys(TestData.PACKAGE_NAME);
        wildPathFullForm.getPackageDescriptionInput().sendKeys(TestData.PACKAGE_DESCRIPTION);
        wildPathFullForm.getPackageCategoryInput().sendKeys(TestData.PACKAGE_CATEGORY);
        wildPathFullForm.getPackagePlaceInput().sendKeys(TestData.PACKAGE_PLACE);
        wildPathFullForm.getPackageDurationDaysInput().sendKeys(TestData.PACKAGE_DURATION_DAYS);
        wildPathFullForm.getPackageDurationNightsInput().sendKeys(TestData.PACKAGE_DURATION_NIGHTS);
        wildPathFullForm.getPackageLocation().sendKeys(TestData.PACKAGE_LOCATION);
        wildPathFullForm.getPackagePrice().sendKeys(TestData.PACKAGE_PRICE_PER_PERSON);
        wildPathFullForm.getPackageDiscount().sendKeys(TestData.PACKAGE_DISCOUNT);
        wildPathFullForm.getPackageDifficulty().sendKeys(TestData.PACKAGE_DIFFICULTY);
        wildPathFullForm.getPackageCancelPolicy().sendKeys(TestData.PACKAGE_CANCEL_POLICY);

        // Completar un include
        wildPathFullForm.getPackageInclude().sendKeys(TestData.PACKAGE_INCLUDES_TEXT1);
        wildPathFullForm.getPackageIncludeIcon().sendKeys(TestData.PACKAGE_INCLUDES_ICON1);
        wildPathFullForm.getPackageIncludeButton().click();

        // NEXT
        wildPathFullForm.getNextButton().click();


        // Subir una imagen
        wildPathFullForm.getPackageImage().sendKeys(
                String.join("\n",
                        TestData.PACKAGE_IMAGE1,
                        TestData.PACKAGE_IMAGE2,
                        TestData.PACKAGE_IMAGE3,
                        TestData.PACKAGE_IMAGE4
                )
        );


        //WebElement imageInput = wildPathFullForm.getPackageImage();
        //imageInput.sendKeys(new File(TestData.PACKAGE_IMAGE1).getAbsolutePath());

        // NEXT
        wildPathFullForm.getNextButton().click();

        // Agregar una fecha disponiblw
//        wildPathFullForm.getDateAvailableDate().sendKeys(TestData.DATE_AVAILABLE1);
//        wildPathFullForm.getDateAvailableSpots().sendKeys(TestData.DATE_AVAILABLE_SPOTS);
//        wildPathFullForm.getDateAvailableButton().click();
        wildPathFullForm.getDateAvailableRangeStart().sendKeys(TestData.DATE_AVAILABLE_START);
        wildPathFullForm.getDateAvailableRangeEnd().sendKeys(TestData.DATE_AVAILABLE_END);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement spotsInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("rangeSpots")));
        spotsInput.clear();
        spotsInput.sendKeys(TestData.DATE_AVAILABLE_SPOTS);

//        wildPathFullForm.getDateAvailableRangeSpots().sendKeys(TestData.DATE_AVAILABLE_SPOTS);
        driver.findElement(By.xpath("//input[@id='day-5']/..")).click();

        WebElement generateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("generateDatesButton")));
        generateButton.click();


        //wildPathFullForm.getDateAvailableRangeButtonGenerate().click();
        wildPathFullForm.getDateAvailableAddRangeButton().click();

        // NEXT
        wildPathFullForm.getNextButton().click();

        // Requirements
        wildPathFullForm.getPackageRequirementTitle().sendKeys(TestData.REQUIREMENT_TITLE);
        wildPathFullForm.getPackageRequirementDescription().sendKeys(TestData.REQUIREMENT_TEXT);
        wildPathFullForm.getPackageRequirementButton().click();

        // NEXT
        wildPathFullForm.getNextButton().click();
    }

    @When("el usuario envia el formulario")
    public void submitForm() {
        wildPathFullForm.getSubmitButton().click();
    }

    @Then("se muestra un mensaje de confirmacion de envío exitoso")
    public void successMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'Toastify__toast') and contains(text(),'Formulario guardado con éxito')]")
        ));
        assertTrue(toast.isDisplayed());
    }

}
