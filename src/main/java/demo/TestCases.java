package demo;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public  void testCase01() throws InterruptedException {
        System.out.println("Test Case 1: Single line input");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        Thread.sleep(1000);
        WebElement nameField = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input"));
        nameField.sendKeys("Sourav Borah");
    }

    public void testCase02() {
        System.out.println("Test Case 2: Multi line input");

        WebElement inputField = driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));

        long epochTimeInMillis = System.currentTimeMillis();

        long epochTimeInSeconds = epochTimeInMillis / 1000;

        String currentEpochTime = String.valueOf(epochTimeInSeconds);

        inputField.sendKeys("I want to be the best QA Engineer! " + currentEpochTime);
    }

    public void testCase03() {
        System.out.println("Test Case 3: Radio buttons");
        WebElement radioButton = driver.findElement(By.xpath("//div[@class='SG0AAe']/child::div[1]"));
        radioButton.click();
    }

    public void testCase04() {
        System.out.println("Test Case 4: Checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//div[@class='Y6Myld']//div[@role='list']/child::div[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//div[@class='Y6Myld']//div[@role='list']/child::div[2]"));
        WebElement checkBox4 = driver.findElement(By.xpath("//div[@class='Y6Myld']//div[@role='list']/child::div[4]"));

        checkBox1.click();
        checkBox2.click();
        checkBox4.click();
    }

    public void testCase05() throws InterruptedException {
        System.out.println("Test Case 5: Dropdowns");

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"));

        dropdown.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement options = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]"));
        wait.until(ExpectedConditions.visibilityOf(options));

        WebElement correctOption = driver.findElement(By.xpath("(//div[@role='option'])//span[contains(text(),'Mr')]"));
        correctOption.click();

        Thread.sleep(1000);
    }

    public void testCase06() throws InterruptedException {
        System.out.println("Test Case 6: Calendars");

        WebElement dateField = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/input"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date currentDate = new Date();

        String latestDate = sdf.format(currentDate);

        dateField.sendKeys(latestDate);
    }

    public void testCase07() {
        System.out.println("Test Case 7: Time");

        WebElement hourField = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/input"));
        WebElement minuteField = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[3]/div/div[1]/div/div[1]/input"));

//        WebElement dropDown = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[4]/div[1]/div[1]"));
//        dropDown.click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement options = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[4]/div[2]"));
//        wait.until(ExpectedConditions.visibilityOf(options));

        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm A");

        String latestTime = currentTime.format(formatter);

        hourField.sendKeys(latestTime.substring(0, 2));
        minuteField.sendKeys(latestTime.substring(3, 5));

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
        WebElement submitBtn = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
        submitBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("formResponse"));

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='vHW8K']"));

        System.out.println("Message: " + successMessage.getText());
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
}
