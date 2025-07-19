package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import steps.Fixtures;

import java.time.Duration;

public class Hooks {

    @Before
    public void beforeScenario() {
        Fixtures.setUpClass(); // Inicializa configuración general

        WebDriver driver = Fixtures.getDriver(); // Crea el driver
        driver.get("http://localhost:5173/login"); // Va al login

        LoginPage loginPage = new LoginPage(driver); // Usa el page object
        loginPage.enterEmail("admin@wildpath.com");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("http://localhost:5173/"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hero-home")));
    }


    @After
    public void tearDown() {
        Fixtures.tearDownClass();
    }

}
