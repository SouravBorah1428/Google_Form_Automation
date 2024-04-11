package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGCases {
    ChromeDriver driver;

    @BeforeSuite
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initializing Elements Class using PageFactory
        PageFactory.initElements(driver, Elements.class);
    }

    @Test
    public void testCase01() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(Elements.nameField));

        Actions.type(Elements.nameField, "Sourav Borah");

        Assert.assertEquals(Elements.nameField.getText(), "Sourav Borah");
    }

    @Test
    public void testCase02() {
        System.out.println("Test Case 2: Multi line input");

        String currentEpochTime = String.valueOf(System.currentTimeMillis() / 1000);

        Actions.type(Elements.inputField,"I want to be the best QA Engineer! " + currentEpochTime);

        Assert.assertEquals(Elements.inputField.getText(), "I want to be the best QA Engineer! " + currentEpochTime);
    }

    public void testCase03() {

    }
}
