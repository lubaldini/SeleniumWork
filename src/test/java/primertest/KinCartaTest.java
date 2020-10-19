package primertest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KinCartaTest {
    private WebDriver driver;

    @Before
    public void NavigateToAmazon() {
        System.setProperty("webdriver.chrome.driver", "/Users/lucasubaldini 1/Documents/SeleniumWork/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //STEP1
        driver.get("https://www.amazon.com");
        System.out.println("Navigate to Amazon.com");
    }

    @Test
    public void SearchAlexa() {
        //Step2
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.clear();
        searchbox.sendKeys("Alexa");
        searchbox.submit();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("Amazon.com : Alexa", driver.getTitle());
        Boolean esVisible = driver.findElement(By.className("a-pagination")).isDisplayed();
        Assert.assertTrue(esVisible);
        System.out.println("Search for Alexa");
        
        //Step3
        driver.findElement(By.xpath("//*[@class='a-normal'][1]")).click();
        Assert.assertEquals("2",driver.findElement(By.xpath("//*[@class='a-selected']")).getText());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Navigate to Page 2");
        
        //Step4
        driver.findElement(By.cssSelector("[data-cel-widget='search_result_2']")).click();
        //WebElement productName =  driver.findElement(By.cssSelector("[data-cel-widget='search_result_2']"));
        //System.out.println(productName.getText());
        //Assert.assertEquals(driver.findElement(By.id("productTitle")).getText(),productName.getText());
        System.out.println("Select 3rd product");
        
        //Step5
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        if(addToCart != null){
            Assert.assertTrue(addToCart.isEnabled());
            System.out.println("Is Available for purchase");
        } else {
            System.out.println("The button is not visible");
        }
        

        

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
