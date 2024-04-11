package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initializing Elements Class using PageFactory
        PageFactory.initElements(driver, Elements.class);
    }

    public  void testCase01() throws InterruptedException {
        System.out.println("Test Case 1: Single line input");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(Elements.nameField));

        Actions.type(Elements.nameField, "Sourav Borah");
    }

    public void testCase02() {
        System.out.println("Test Case 2: Multi line input");

        String currentEpochTime = String.valueOf(System.currentTimeMillis() / 1000);

        Actions.type(Elements.inputField,"I want to be the best QA Engineer! " + currentEpochTime);
    }

    public void testCase03() {
        System.out.println("Test Case 3: Radio buttons");
        Actions.click(Elements.radioButton);
    }

    public void testCase04() {
        System.out.println("Test Case 4: Checkboxes");

        Actions.click(Elements.checkBox1);
        Actions.click(Elements.checkBox2);
        Actions.click(Elements.checkBox4);
    }

    public void testCase05() throws InterruptedException {
        System.out.println("Test Case 5: Dropdowns");

        Actions.click(Elements.titleDropDown);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(Elements.titleOptions));

        Actions.click(Elements.titleCorrectOption);

        wait.until(ExpectedConditions.invisibilityOf(Elements.titleOptions));
    }

    public void testCase06() throws InterruptedException {
        System.out.println("Test Case 6: Calendars");

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date currentDate = new Date();

        String latestDate = sdf.format(currentDate);

        Actions.type(Elements.dateField, latestDate);
    }

    public void testCase07() {
        System.out.println("Test Case 7: Time");

//        Actions.click(Elements.am_pm_dropdown);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(Elements.am_pm_options));

        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm A");

        String latestTime = currentTime.format(formatter);

        Actions.type(Elements.hourField, latestTime.substring(0, 2));
        Actions.type(Elements.minuteField, latestTime.substring(3, 5));

//        WebElement correctOption = driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb']//span[contains(text(),'" + latestTime.substring(6) +"')]"));
//        correctOption.click();
    }

    public void testCase08() throws InterruptedException {
        System.out.println("Test Case 8: Alerts");

        driver.get("https://www.amazon.in/");

        driver.switchTo().alert().dismiss();
    }

    public void testCase09() {
        System.out.println("Test Case 9: Submit");
        Actions.click(Elements.submitBtn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("formResponse"));

        System.out.println("Message: " + Elements.successMessage.getText());
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
}
