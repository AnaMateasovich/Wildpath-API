package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("loginButton"));
    }

    public void enterEmail(String email) {
        getEmailInput().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}
