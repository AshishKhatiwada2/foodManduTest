package com.example.seleniumtry3;

import org.apache.commons.lang.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PositiveTests {

    public WebDriver driver;
    public FoodManduWebComponents foodManduWebcomponents ;
    public  PositiveTests()
    {
        // create driver
        foodManduWebcomponents = new FoodManduWebComponents(3,"webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        foodManduWebcomponents.MaximizeWindow();
    }

    @Test(priority = 0)
    @Parameters("siteName")
    public  void  correctLoginLinkClick(String siteName)
    {
//        foodManduWebcomponents.SetupBaseUrl("https://foodmandu.com/");
        foodManduWebcomponents.SetupBaseUrl(siteName);
        foodManduWebcomponents.LinkOrButtonClick("//li/button[text()='Login']");

    }
    @Test(priority = 1)
    @Parameters({"email","password"})
    public  void correctLoginTest(String email, String password)
    {
        System.out.println("Starting IncorrectUsername Test.");
        String xpathInputEmail="//div/input[@type='email']";
        String xpathInputPassword= "//div/input[@type='password']";
        String xpathLoginButton = "//button[text()='Login'][@type='submit']";
//        String emailValue ="test77282@gmail.com";
//        String passwordValue="Test!@#123";

        foodManduWebcomponents.InputText(xpathInputEmail,email);
        foodManduWebcomponents.InputText(xpathInputPassword,password);
        foodManduWebcomponents.LinkOrButtonClick(xpathLoginButton);

    }

    @Test(priority = 2)
    @Parameters("searchRestaurantName")
    public void correctSearchTest(String searchRestaurantName)
    {
        String InputTextXpath= "//div[@class='row']/div/input[@type='search']";
        String InputTextValue = "kiran";
        String ButtonXpath ="//div[@class='row']/div/button[@type='button']/span[text()='Find Restaurants']";

        foodManduWebcomponents.InputText(InputTextXpath,searchRestaurantName);
        foodManduWebcomponents.LinkOrButtonClick(ButtonXpath);

    }

    @Test(priority = 3)
    public  void  correctSelectResturant()
    {
        String xpathOfResturantItem = "//div/div[@class='listing']/div[@class='listing__photo']/a";
        foodManduWebcomponents.LinkOrButtonClick(xpathOfResturantItem);

    }

    @Test(priority = 4)
    @Parameters("searchFoodItemName")
    public  void  searchFoodItem(String searchFoodItemName)
    {
        String xpathFoodItem = "//div[@class='menu__search']/div/input[@type='search']";
        String foodNameToSearch = "momo";
        foodManduWebcomponents.InputText(xpathFoodItem,searchFoodItemName);

    }

    @Test(priority = 5)
    public  void  correctClickFirstItem()
    {
        String xpathFirstItem = "//li/div[@class='menu__price']/a";
        foodManduWebcomponents.LinkOrButtonClick(xpathFirstItem);

    }
    @Test(priority = 6)
    public void correctIncrementOrder()
    {
        String xpathOfLabel="//div[@class='row']/div/button[@type='button']/div/span[@class='ng-binding']";
        String xpathOfItemCounterTextField ="//span/input[@type='number']";
        sleep(2000);

        String totalPrice= foodManduWebcomponents.GetTextFromLabel(xpathOfLabel);
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
        if (totalPriceFloat <500)
        {

            foodManduWebcomponents.InputTextClear(xpathOfItemCounterTextField);
            sleep(500);
            foodManduWebcomponents.InputText(xpathOfItemCounterTextField,String.valueOf(itemNumberNeeded));

        }


    }

    @Test(priority = 7)
    public  void  correctAddToBucket()
    {
        String xpathButtonToClick ="//div[@class='row']/div/button[@type='button']/div/span[@class='ng-binding']";
        sleep(200);
        foodManduWebcomponents.LinkOrButtonClick(xpathButtonToClick);


    }
    @Test(priority = 8)
    public  void correctClickMyBag()
    {
        String xpathMyBagLink ="//ul/li[@title='My Bag']/span";
        foodManduWebcomponents.LinkOrButtonClick(xpathMyBagLink);


    }
    @Test(priority = 9)
    public  void correctProceedCheckoutButtonClick()
    {
        String xpathProceedCheckoutButton ="//tr/td/button[contains(text(),'Proceed to Checkout')]";
        foodManduWebcomponents.LinkOrButtonClick(xpathProceedCheckoutButton);

    }
    @Test(priority = 10)
    public  void correctSetupDateTimeAndCheckout()
    {
        String xpathRadioFirstAddressLink ="//div/input[@type='radio'][@name='delivery_address']";
        String xpathRadioLateDelivery = "//div[@class='row']/div/p/label[contains(text(),' For Later Date')]/preceding-sibling:: input[@type='radio' and @name='deliverydt']";
        String xpathDdlDate ="//div/p/label[contains(text(),'Date')]/following-sibling::select";
        String xpathDdlDateOptions = "//div/p/label[contains(text(),'Date')]/following-sibling::select/option[contains(text(),'Sunday')]";
        String xpathDdlTime ="//div/label[contains(text(),'Time')]/following-sibling::select";
        String xpathDdlTimeOptions ="//div/label[contains(text(),'Time')]/following-sibling::select/option[contains(text(),'1:00PM - 1:30PM')]";
        String xpathRbCashOnDelivery = "//div[@class='row']/div/p/label[contains(text(),'Cash on Delivery')]/preceding-sibling::input[@name='paymentOption'][@type='radio']";
        String xpathContinueCheckoutButton = "//div/a[contains(text(),'Go Back')]/following-sibling:: button[contains(text(),'Continue')]";
        String xpathTextSpecialInstructions = "//div[contains(text(),'SPECIAL INSTRUCTIONS')]/following-sibling::div/div[@class='row']/div/textarea";
        String specialInstructions="Cancel this Order: This order is only for testing. Please do not put effort to full fill this order. ";

        foodManduWebcomponents.LinkOrButtonClick(xpathRadioFirstAddressLink);
        foodManduWebcomponents.LinkOrButtonClick(xpathRadioLateDelivery);
        foodManduWebcomponents.LinkOrButtonClick(xpathDdlDate);
        foodManduWebcomponents.LinkOrButtonClick(xpathDdlDateOptions);
        foodManduWebcomponents.LinkOrButtonClick(xpathDdlTime);
        foodManduWebcomponents.LinkOrButtonClick(xpathDdlTimeOptions);
        foodManduWebcomponents.LinkOrButtonClick(xpathRbCashOnDelivery);
        foodManduWebcomponents.LinkOrButtonClick(xpathRbCashOnDelivery);
        foodManduWebcomponents.InputText(xpathTextSpecialInstructions,specialInstructions);

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
        String strNew = s[s.length-1];
        String strNew1 = strNew.replace(",", "");
        return  strNew1;
//        return s[s.length-1];

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
