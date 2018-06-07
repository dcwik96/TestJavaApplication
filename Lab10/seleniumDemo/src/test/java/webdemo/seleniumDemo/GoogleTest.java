package webdemo.seleniumDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class GoogleTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() throws Exception {
        // Od wersji selenium 3.0 samo FirefoxDriver nie wystarcza
        // Należy dodać sterownik geckodriver
        // Do pobrania tutaj: https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testTitlePage() {
        driver.get("https://duckduckgo.com/");
        assertEquals("DuckDuckGo — Privacy, simplified.", driver.getTitle());
    }

    @Test
    public void testClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Mateusz Miotk");
        driver.findElement(By.id("search_button_homepage")).click();
        wait.until(ExpectedConditions.titleIs("Mateusz Miotk at DuckDuckGo"));
        assertEquals("Mateusz Miotk at DuckDuckGo", driver.getTitle());
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
