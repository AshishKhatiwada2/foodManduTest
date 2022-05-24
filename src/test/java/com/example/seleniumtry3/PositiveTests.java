package com.example.seleniumtry3;

import org.apache.commons.lang.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PositiveTests {

    public WebDriver driver;
    public  PositiveTests()
    {
        // create driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test(priority = 0)
    public  void  correctLoginLinkClick()
    {
        // sleep for 2 Seconds.

        sleep(2000);
        // maximize browser window
        driver.manage().window().maximize();
        driver.get("https://foodmandu.com/");
        sleep(2000);
        waitTillVisible("//li/button[text()='Login']");
        WebElement linkToLoginButton=  driver.findElement(By.xpath("//li/button[text()='Login']"));
        linkToLoginButton.click();
        //sleep(1000);

    }
    @Test(priority = 1)
    public  void correctLoginTest()
    {
        System.out.println("Starting IncorrectUsername Test.");
        waitTillVisible("//div/input[@type='email']");
        WebElement inputEmailField= driver.findElement(By.xpath("//div/input[@type='email']"));
        WebElement inputPasswordField= driver.findElement(By.xpath("//div/input[@type='password']"));
        WebElement loginButton= driver.findElement(By.xpath("//button[text()='Login'][@type='submit']"));

        inputEmailField.sendKeys("test77282@gmail.com");
        inputPasswordField.sendKeys("Test!@#123");
        loginButton.click();
    }

    @Test(priority = 2)
    public void correctSearchTest()
    {
        waitTillVisible("//div[@class='row']/div/input[@type='search']");
        Actions actions=new Actions(driver);
        WebElement searchTextInput= driver.findElement(By.xpath("//div[@class='row']/div/input[@type='search']"));
        WebElement searchButton=driver.findElement(By.xpath("//div[@class='row']/div/button[@type='button']/span[text()='Find Restaurants']"));
        actions.moveToElement(searchTextInput).click().build().perform();
        searchTextInput.sendKeys("kiran");
        waitTillVisible("//div[@class='row']/div/button[@type='button']/span[text()='Find Restaurants']");
        searchButton.click();
    }

    @Test(priority = 3)
    public  void  correctSelectResturant()
    {
        sleep(1000);
        waitTillVisible("//div/div[@class='listing']/div[@class='listing__photo']/a");
        WebElement  resturantItem= driver.findElement(By.xpath("//div/div[@class='listing']/div[@class='listing__photo']/a"));
        resturantItem.click();
    }

    @Test(priority = 4)
    public  void  searchFoodItem()
    {
        sleep(2000);
        //waitTillVisible("//div[@class='menu__search']/div/input[@type='search']");
        WebElement foodSearchBar= driver.findElement(By.xpath("//div[@class='menu__search']/div/input[@type='search']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(foodSearchBar).click().build().perform();
        foodSearchBar.sendKeys("momo");


    }

    @Test(priority = 5)
    public  void  correctClickFirstItem()
    {
        waitTillVisible("//li/div[@class='menu__price']/a");
        WebElement foodItem= driver.findElement(By.xpath("//li/div[@class='menu__price']/a"));
        foodItem.click();
        /*
        List<WebElement> foodItems= driver.findElements(By.xpath("//ul[@class='menu__item']/li")).stream().findFirst();
        for (WebElement foodItem: foodItems  )
        {

            foodItem.findElement(By.xpath(""))
        }

         */
    }
    @Test(priority = 6)
    public void correctIncrementOrder()
    {
        sleep(2000);
       //waitTillVisible("//div[@class='row']/div/div[@class='row']/div/button");
        WebElement allButtonElement= driver.findElement(By.xpath("//div[@class='row']/div/div[@class='row']/div/button"));
        List<WebElement> checkoutButton=driver.findElements(By.xpath("//div[@class='item__footer']/div[@class='row']/div/button[@ng-click='AddToCart(ProductItem)']"));
        // WebElement footerElement= driver.findElement(By.xpath("//div[@class='item__footer']/div[@class='row']/div/button"));




        //WebElement inputCounter= allButtonElement.findElement(By.xpath("//span/input[@type='number']"));
        //WebElement incrementButton= allButtonElement.findElement(By.xpath("//span[@class='icon-add']"));
        //WebElement decrementButton= allButtonElement.findElement(By.xpath("//span[@class='icon-remove']"));
        sleep(1000);
        waitTillVisible("//div[@class='row']/div/button[@type='button']/div/span[@class='ng-binding']");
        WebElement totalPriceLabel=driver.findElement(By.xpath("//div[@class='row']/div/button[@type='button']/div/span[@class='ng-binding']"));
        String totalPrice=totalPriceLabel.getText();
        System.out.println(totalPrice);
        double totalPriceFloat= 1;
        if(totalPrice!= null)
        {
            System.out.println("Price of mutton = "+totalPrice);
            totalPrice = getDigitFromWord(totalPrice);
            System.out.println(" Total price float= +" + totalPriceFloat +" and totalPrice = "+totalPrice);

            totalPriceFloat= Float.parseFloat(totalPrice);
        }

         float MinimumAmount =500f;
        int itemNumberNeeded= getItemCount(totalPriceFloat,500);
        WebElement inputCounter= allButtonElement.findElement(By.xpath("//span/input[@type='number']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(inputCounter).click().build().perform();

        inputCounter.sendKeys(String.valueOf(itemNumberNeeded));

    }

    @Test(priority = 7)
    public  void  correctAddToBucket()
    {
        sleep(2000);
        //waitTillVisible("//div[@class='row']/div/button[@type='button']/div/span[@class='ng-binding']");
        WebElement checkOutButton=driver.findElement(By.xpath("//div[@class='row']/div/button[@type='button']/div/span[@class='ng-binding']"));
        checkOutButton.click();

    }
    @Test(priority = 8)
    public  void correctClickMyBag()
    {
        waitTillVisible("//ul/li[@title='My Bag']/span");
        WebElement myBagLink = driver.findElement(By.xpath("//ul/li[@title='My Bag']/span"));
        myBagLink.click();

    }
    @Test(priority = 9)
    public  void correctProceedCheckoutButtonClick()
    {
        waitTillVisible("//tr/td/button[contains(text(),'Proceed to Checkout')]");
        WebElement checkOutButton = driver.findElement(By.xpath("//tr/td/button[contains(text(),'Proceed to Checkout')]"));
        checkOutButton.click();

    }
    @Test(priority = 10)
    public  void correctSetupDateTimeAndCheckout()
    {
        waitTillVisible("//div/input[@type='radio'][@name='delivery_address']");
        WebElement radioFirstAddress= driver.findElement(By.xpath("//div/input[@type='radio'][@name='delivery_address']"));
        radioFirstAddress.click();

        WebElement radioLateDelivery= driver.findElement(By.xpath("//div[@class='row']/div/p/label[contains(text(),' For Later Date')]/preceding-sibling:: input[@type='radio' and @name='deliverydt']"));
        radioLateDelivery.click();

        WebElement ddlDate= driver.findElement(By.xpath("//div/p/label[contains(text(),'Date')]/following-sibling::select"));
        ddlDate.click();

        waitTillVisible("//div/p/label[contains(text(),'Date')]/following-sibling::select/option[contains(text(),'Sunday')]");
        WebElement ddlDateOption= driver.findElement(By.xpath("//div/p/label[contains(text(),'Date')]/following-sibling::select/option[contains(text(),'Sunday')]"));
        ddlDateOption.click();

        WebElement ddlTime= driver.findElement(By.xpath("//div/label[contains(text(),'Time')]/following-sibling::select"));
        ddlTime.click();

        waitTillVisible("//div/label[contains(text(),'Time')]/following-sibling::select/option[contains(text(),'1:00PM - 1:30PM')]");
        WebElement ddlTimeOption= driver.findElement(By.xpath("//div/label[contains(text(),'Time')]/following-sibling::select/option[contains(text(),'1:00PM - 1:30PM')]"));
        ddlTimeOption.click();

        waitTillVisible("//div[@class='row']/div/p/label[contains(text(),'Cash on Delivery')]/preceding-sibling::input[@name='paymentOption'][@type='radio']");
        WebElement rbCashOnDelivery= driver.findElement(By.xpath("//div[@class='row']/div/p/label[contains(text(),'Cash on Delivery')]/preceding-sibling::input[@name='paymentOption'][@type='radio']"));
        rbCashOnDelivery.click();

        WebElement textSpecialInstruction= driver.findElement(By.xpath("//div[contains(text(),'SPECIAL INSTRUCTIONS')]/following-sibling::div/div[@class='row']/div/textarea"));
        rbCashOnDelivery.click();
        Actions actions=new Actions(driver);
        actions.moveToElement(textSpecialInstruction).click().build().perform();

        textSpecialInstruction.sendKeys(String.valueOf("Cancel this Order: This order is only for testing. Please do not put effort to full fill this order. "));


        WebElement checkOutContinueButton = driver.findElement(By.xpath("//div/a[contains(text(),'Go Back')]/following-sibling:: button[contains(text(),'Continue')]"));
        //checkOutContinueButton.click();

    }
    public int getItemCount(double unitPrice, double minimumAmount)
    {
       int totalItemNumberShouldBeBought=0;
       for (int i=0;unitPrice*totalItemNumberShouldBeBought<=minimumAmount;i++)
       {
           totalItemNumberShouldBeBought++;
       }

        return  totalItemNumberShouldBeBought;
    }

    public  String  getDigitFromWord(String MixedDigitLetter)
    {

        String[] s = MixedDigitLetter.split(" ");
        return s[s.length-1];

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
