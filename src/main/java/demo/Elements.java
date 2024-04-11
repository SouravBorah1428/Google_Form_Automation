package demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {
    @FindBy (xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")
    public static WebElement nameField;

    @FindBy (xpath = "//textarea[@aria-label='Your answer']")
    public static WebElement inputField;

    @FindBy (xpath = "//div[@class='SG0AAe']/child::div[1]")
    public static WebElement radioButton;

    @FindBy (xpath = "//div[@class='Y6Myld']//div[@role='list']/child::div[1]")
    public static WebElement checkBox1;

    @FindBy (xpath = "//div[@class='Y6Myld']//div[@role='list']/child::div[2]")
    public static WebElement checkBox2;

    @FindBy (xpath = "//div[@class='Y6Myld']//div[@role='list']/child::div[4]")
    public static WebElement checkBox4;

    @FindBy (xpath = "//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']")
    public static WebElement titleDropDown;

    @FindBy (xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]")
    public static WebElement titleOptions;

    @FindBy (xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]/span")
    public static WebElement titleCorrectOption;

    @FindBy (xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/input")
    public static WebElement dateField;

    @FindBy (xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/input")
    public static WebElement hourField;

    @FindBy (xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[3]/div/div[1]/div/div[1]/input")
    public static WebElement minuteField;

    @FindBy (xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[4]/div[1]/div[1]")
    public static WebElement am_pm_dropdown;

    @FindBy (xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[4]/div[2]")
    public static WebElement am_pm_options;

    @FindBy (xpath = "//span[contains(text(),'Submit')]")
    public static WebElement submitBtn;

    @FindBy (xpath = "//div[@class='vHW8K']")
    public static WebElement successMessage;
}
