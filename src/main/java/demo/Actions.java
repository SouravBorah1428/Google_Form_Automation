package demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions {
    public static ChromeDriver driver;

    public Actions() {
        driver = new ChromeDriver();
    }
    public static void type(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void click(WebElement element) {
        element.click();
    }
}
