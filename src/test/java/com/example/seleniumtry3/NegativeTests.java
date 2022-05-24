package com.example.seleniumtry3;

import com.codeborne.selenide.SelenideElement;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    public WebDriver driver;
    public  NegativeTests()
    {
        // create driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test(priority = 0)
    public  void  loginLinkClick()
    {
        // sleep for 2 Seconds.
        sleep(2000);
        // maximize browser window
        driver.manage().window().maximize();
        driver.get("https://foodmandu.com/");
        sleep(2000);
        WebElement linkToLoginButton=  driver.findElement(By.xpath("//li/button[text()='Login']"));
        linkToLoginButton.click();
        //sleep(1000);

    }
    @Test(priority = 1)
    public  void incorrectLoginTest()
    {
        System.out.println("Starting IncorrectUsername Test.");

        WebElement inputEmailField= driver.findElement(By.xpath("//div/input[@type='email']"));
        WebElement inputPasswordField= driver.findElement(By.xpath("//div/input[@type='password']"));
        WebElement loginButton= driver.findElement(By.xpath("//button[text()='Login'][@type='submit']"));

        inputEmailField.sendKeys("test77282@gmail.com");
        inputPasswordField.sendKeys("Test!@#123");
        loginButton.click();
    }

    @Test(priority = 2)
    public void incorrectSearchTest()
    {
        Actions actions=new Actions(driver);
        WebElement searchTextInput= driver.findElement(By.xpath("//div[@class='row']/div/input[@type='search']"));
        WebElement searchButton=driver.findElement(By.xpath("//div[@class='row']/div/button[@type='button']/span[text()='Find Restaurants']"));
        actions.moveToElement(searchTextInput).click().build().perform();
        searchTextInput.sendKeys("bajeko");
        sleep(500);
        searchButton.click();
    }

    @Test(priority = 3)
    public  void  incorrectAddToCart()
    {

    }
    @Test(priority = 4)
    public void incorrectCheckout()
    {

    }
    private void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
