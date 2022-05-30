package com.example.seleniumtry3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FoodManduWebComponents {
    public WebDriver driver;

    public FoodManduWebComponents(int timeoutSeconds , String webDriver, String webDriverLocation) {
        // create driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    public  void  MaximizeWindow()
    {
        sleep(2000);
        // maximize browser window
        driver.manage().window().maximize();
    }
    public  void  SetupBaseUrl(String baseUrl)
    {
        driver.get(baseUrl);
        sleep(2000);
    }
    public void LinkOrButtonClick(String xpath)
    {
        sleep(1000);
        waitTillVisible(xpath);
        WebElement linkToLoginButton=  driver.findElement(By.xpath(xpath));
        linkToLoginButton.click();
        sleep(1000);
    }
    public  void  InputText(String xpathOfInputText, String valueToBeEntered)
    {
        waitTillVisible(xpathOfInputText);
        Actions actions=new Actions(driver);
        WebElement searchTextInput= driver.findElement(By.xpath(xpathOfInputText));
        actions.moveToElement(searchTextInput).click().build().perform();
        searchTextInput.sendKeys(valueToBeEntered);
    }
    public  void  InputTextClear(String xpathOfInputTextToBeCleared)
    {
        waitTillVisible(xpathOfInputTextToBeCleared);
        Actions actions=new Actions(driver);
        WebElement searchTextInput= driver.findElement(By.xpath(xpathOfInputTextToBeCleared));
        actions.moveToElement(searchTextInput).click().build().perform();
        searchTextInput.clear();
        searchTextInput.sendKeys("");
        sleep(200);
    }
    public  String GetTextFromLabel (String xpathOfLabel)
    {
        sleep(100);
        waitTillVisible("//div[@class='row']/div/button[@type='button']/div/span[@class='ng-binding']");
        WebElement totalPriceLabel=driver.findElement(By.xpath("//div[@class='row']/div/button[@type='button']/div/span[@class='ng-binding']"));
        String totalPrice=totalPriceLabel.getText();
        return  totalPrice;
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
    private  void  waitTillVisible(String xpath)
    {
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
