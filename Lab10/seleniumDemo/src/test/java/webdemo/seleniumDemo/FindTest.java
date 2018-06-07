package webdemo.seleniumDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FindTest {

    // Przykłady znajdowania elementów na stronie www

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() throws Exception {

        /*ZADANIE 5
        * DLA OPERA
        * System.setProperty("webdriver.opera.driver", "resources/operadriver");
        * driver = new OperaDriver();
        * -----------------------------
        * DLA INTERNET EXPLORER
        * System.setProperty("webdriver.ie.driver","resources/IEDriverServer.exe");
        * driver = new InternetExplorerDriver();
        * */

        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Implicity wait -> max czas na znalezienie elementu na stronie

    }

    @BeforeEach
    public void setup() {
        driver.get("https://www.google.pl");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void findById() {
        WebElement element = driver.findElement(By.id("lst-ib"));
        assertNotNull(element);
    }

    @Test
    public void findByName() {
        WebElement element = driver.findElement(By.name("q"));
        assertNotNull(element);
    }

    @Test
    public void findByClass() {
        WebElement element = driver.findElement(By.className("gsfi"));
        assertNotNull(element);
    }

    @Test
    public void findBylinkText() {
        WebElement element = driver.findElement(By.linkText("Gmail"));
        assertNotNull(element);
    }

    @Test
    public void findByPartiallinkText() {
        WebElement element = driver.findElement(By.partialLinkText("Ima"));
        assertNotNull(element);
    }

    @Test
    public void findByTagName() {
        WebElement element = driver.findElement(By.tagName("div"));
        assertNotNull(element);
    }

    @Test
    public void findByCssSelector() {
        WebElement element = driver.findElement(By.cssSelector("input.gsfi"));
        assertNotNull(element);
    }

    @Test
    public void testClick() {
        driver.findElement(By.id("lst-ib")).sendKeys("woda");
        driver.findElement(By.name("btnK")).click();
        assertEquals("woda - Google Search", driver.getTitle());

    }

    @Test
    public void testNotFound() {
        driver.findElement(By.id("lst-ib")).sendKeys("123d2qwdq32d1");
        driver.findElement(By.name("btnK")).click();

        assertTrue(driver.getPageSource().contains("did not match"));
    }

}
