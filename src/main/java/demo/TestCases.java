package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Test Case 1: Single line input");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebElement nameField = driver.findElement(By.xpath("//div[@class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd']//input[@type='text']"));
        nameField.sendKeys("Sourav Borah");
    }

    public void testCase02() {
        System.out.println("Test Case 2: Multi line input");
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


}
