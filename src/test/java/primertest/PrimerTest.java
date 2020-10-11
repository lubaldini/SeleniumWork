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

public class PrimerTest {
    
    private WebDriver driver;
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/lucasubaldini 1/Documents/SeleniumWork/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    
    @Test
    public void testGooglePage() {
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("Gilada de la del video de youtube");
        searchbox.submit();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        Assert.assertEquals("Gilada de la del video de youtube - Buscar con Google", driver.getTitle());
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
