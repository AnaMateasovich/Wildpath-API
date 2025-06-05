package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fixtures {

    private static WebDriver driver;

    public static void setUpClass() {
        String pathChrome = "C:\\Ana\\Programacion\\Java\\Selenium driver\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChrome);
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            throw new IllegalAccessError("Webdriver is not initialized. Call setUpClass() first.");
        }
        return driver;
    }

    public static void tearDownClass() {
        driver.quit();
    }

}
