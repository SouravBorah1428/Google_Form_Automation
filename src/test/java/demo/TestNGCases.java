package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestNGCases {
    ChromeDriver driver;

    @BeforeSuite (enabled = true)
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initializing Elements Class using PageFactory
        PageFactory.initElements(driver, Elements.class);
    }

    @Test (description = "Verify user can enter their name", priority = 1,enabled = true)
    public void testCase01() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(Elements.nameField));

        Actions.type(Elements.nameField, "Sourav Borah");

        Assert.assertTrue(Elements.nameField.getAttribute("data-initial-value").equals("Sourav Borah"));
    }

    @Test (description = "Verify user can enter their input in the input field", priority = 2, enabled = true)
    public void testCase02() {
        String currentEpochTime = String.valueOf(System.currentTimeMillis() / 1000);

        Actions.type(Elements.inputField,"I want to be the best QA Engineer! " + currentEpochTime);

        Assert.assertTrue(Elements.inputField.getAttribute("data-initial-value").equals("I want to be the best QA Engineer! " + currentEpochTime));
    }

    @Test (description = "Verify user can select the radio button", priority = 3, enabled = true)
    public void testCase03() {
        Actions.click(Elements.radioButton);
        Assert.assertTrue(Elements.radioButton.getAttribute("aria-checked").equals("true"));
    }

    @Test (description = "Verify user can select the checkboxes", priority = 4, enabled = true)
    public void testCase04() {
        Actions.click(Elements.checkBox1);
        Actions.click(Elements.checkBox2);
        Actions.click(Elements.checkBox4);

        Assert.assertTrue(Elements.checkBox1.getAttribute("aria-checked").equals("true"));
        Assert.assertTrue(Elements.checkBox2.getAttribute("aria-checked").equals("true"));
        Assert.assertTrue(Elements.checkBox4.getAttribute("aria-checked").equals("true"));
    }

    @Test (description = "Verify user can the correct option from the dropdown", priority = 5, enabled = true)
    public void testCase05() {
        Actions.click(Elements.titleDropDown);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(Elements.titleOptions));

        Actions.click(Elements.titleCorrectOption);

        wait.until(ExpectedConditions.invisibilityOf(Elements.titleOptions));

        Assert.assertEquals(Elements.titleCorrectOption.getText(), "Mr");
    }

    @Test (description = "Verify user can enter the date", priority = 6, enabled = true)
    public void testCase06() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date currentDate = new Date();

        String latestDate = sdf.format(currentDate);

        Actions.type(Elements.dateField, latestDate);

        Assert.assertEquals(Elements.dateField.getAttribute("data-initial-value"), latestDate.substring(6) + "-" + latestDate.substring(3,5) + "-" + latestDate.substring(0,2));
    }

    @Test (description = "Verify user can enter the time", priority = 7, enabled = true)
    public void testCase07() {
        //  Actions.click(Elements.am_pm_dropdown);
        //
        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //  wait.until(ExpectedConditions.visibilityOf(Elements.am_pm_options));

        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm A");

        String latestTime = currentTime.format(formatter);

        Actions.type(Elements.hourField, latestTime.substring(0, 2));
        Actions.type(Elements.minuteField, latestTime.substring(3, 5));

        //  WebElement correctOption = driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb']//span[contains(text(),'" + latestTime.substring(6) +"')]"));
        //  correctOption.click();

        Assert.assertEquals(Elements.hourField.getAttribute("data-initial-value"), latestTime.substring(0, 2));
        Assert.assertEquals(Elements.minuteField.getAttribute("data-initial-value"), latestTime.substring(3, 5));
    }

    @Test (description = "Verify user can dismiss the alerts", priority = 8, enabled = true)
    public void testCase08() {
        String currentUrl = driver.getCurrentUrl();

        driver.get("https://www.amazon.in/");

        driver.switchTo().alert().dismiss();

        Assert.assertEquals(driver.getCurrentUrl(), currentUrl);
    }

    @Test (description = "Verify user can submit the form successfully", priority = 9, enabled = true)
    public void testCase09() {
        Actions.click(Elements.submitBtn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("formResponse"));

        System.out.println("Message: " + Elements.successMessage.getText());

        Assert.assertTrue(driver.getCurrentUrl().contains("/formResponse"));
    }

    @AfterSuite (enabled = true)
    public void endTest()
    {
        driver.close();
        driver.quit();
    }
}
