import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

import java.util.concurrent.TimeUnit;

public class ArrayList extends Utils {

    LoadProps props = new LoadProps();

    SoftAssert softAssert = new SoftAssert();

    @Before

    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver","src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

        //open the browser
        driver = new ChromeDriver();

        //maximize the browser window screen
        driver.manage().window().fullscreen();

        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //open the website
        driver.get(props.getProperty("url"));

    }

    @After

    public void closeBrowser () {
        driver.close();}
    @Test
    public void userShouldAbleToLeaveCommentinNewOnlineStoreIsOpenAndCommentMustBeAtBottomOfPage (){

        //click on New online store is open

        clickOnElement(By.linkText("New online store is open!"));

        //enter Title
        enterText(By.className("enter-comment-title"),props.getProperty("title"));

        //enter comment

        enterText(By.className("enter-comment-text"),props.getProperty("comment"));

        //click on NEW COMMENT button

        clickOnElement(By.xpath("//input[@name = 'add-comment']"));

        //test pass or fail

        //check if comment is added successfully-

        String expectedMSG = "News comment is successfully added.";

        String actualMSG = getTextFromElement(By.xpath("//div[@class='result']"));

        //String actualMSG = getTextFromElement(By.linkText(" News comment is successfully added."));


        Assert.assertEquals(actualMSG,expectedMSG);

        //To check comment is added in comment box at bottom.

        String actualMSG1 =  getTextFromElement(By.xpath("//div/p[@class='comment-text' and contains (text ( ) ,'best website for learning. Thanks')]"));
        String expectedMSG2 = "best website for learning. Thanks";

        Assert.assertEquals(actualMSG1,expectedMSG2);
    }

    @Test
    public void userShouldAbleToAddToAnyTwoProductInCompareListAndAbleToCompareAddedProduct  () throws InterruptedException {

        //click on first product to compare to list

        Thread.sleep(2000);

        clickOnElement(By.xpath("//input[@onclick = 'return AjaxCart.addproducttocomparelist(\"/compareproducts/add/1\"),!1']"));

        // to check first product added to compare list or not

        String actualMSG1 = getTextFromElement(By.xpath("//div[@class='bar-notification success']"));
        String expectedMSG1 = "The product has been added to your product comparison";

        Assert.assertEquals(actualMSG1,expectedMSG1);

        //click on second product to compare to list

        Thread.sleep(2000);

        clickOnElement(By.xpath("//input[@onclick='return AjaxCart.addproducttocomparelist(\"/compareproducts/add/4\"),!1']"));

        // to check second product added to compare list or not
        String actualMSG2 = getTextFromElement(By.xpath("//div[@class='bar-notification success']"));
        String expectedMSG2 = "The product has been added to your product comparison";

        Assert.assertEquals(actualMSG2,expectedMSG2);

        //navigate to compare list

       // clickOnElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a"));

        Thread.sleep(2000);

        clickOnElement(By.partialLinkText("product comparison"));

        //To check both product should be added to compare list on or not

//        List <WebElement> al = driver.findElements(By.xpath())

    }
    @Test
    public void userShouldAbleToSerachProductByEnteringTextAndAllSearchedProductHaveThatEnteredText(){


        //enter text for search product

        enterText(By.xpath("//input[@class='search-box-text ui-autocomplete-input']"),props.getProperty("searchtext"));

        //click on search button

        clickOnElement(By.xpath("//input[@class='button-1 search-box-button' ]"));

//       List <WebElement> al1 = driver.findElements(By.xpath("//h2[@class='product-title']"));
//
//       int count = 0;
//
//        for (WebElement e: al1){





       }









    }






