package Day1;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;



public class FitPeoAutomationTest {



    private WebDriver driver;



    @BeforeClass

    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }



    @Test

    public void testFitPeo() throws InterruptedException {

       

        driver.get("https://fitpeo.com");



        WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));

        revenueCalculatorLink.click();



    

//        WebElement sliderSection = driver.findElement(By.id("slider-section-id")); 

//        ((RemoteWebDriver) driver).executeScript("arguments[0].scrollIntoView(true);", sliderSection);



        

        JavascriptExecutor js=(JavascriptExecutor) driver;

	     for(int i=0;i<=2;i++) {

			    js.executeScript("window.scrollBy(0,200)");

               Thread.sleep(1000);

	     }

        

      Thread.sleep(2000);

        WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']")); 

        WebElement textField = driver.findElement(By.id(":r0:")); 

        

         ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '820');", slider);

        Assert.assertEquals(textField.getAttribute("value"), "820");



       

        textField.clear();

        textField.sendKeys("560");

        textField.sendKeys(org.openqa.selenium.Keys.RETURN); // Simulate Enter key

      WebElement sliderValue = driver.findElement(By.id("slider-id"));

       Assert.assertEquals(sliderValue.getAttribute("value"), "560");



        // Select CPT Codes

        WebElement cpt99091 = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span)[1]")); 

        WebElement cpt99453 = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span)[3]")); 

        WebElement cpt99454 = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span)[5]")); 

        WebElement cpt99474 = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span)[15]")); 

        

        cpt99091.click();

        cpt99453.click();

        cpt99454.click();

        cpt99474.click();



        Thread.sleep(2000);

        WebElement totalReimbursement = driver.findElement(By.xpath("//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-1lnu3ao']/p[4]/p")); 

        Assert.assertEquals(totalReimbursement.getText(), "$27000");

    }



    @AfterClass

    public void tearDown() {

        if (driver != null) {

            driver.quit();

       }

    }

}
