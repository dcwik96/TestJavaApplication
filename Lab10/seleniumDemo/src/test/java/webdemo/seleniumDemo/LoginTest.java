package webdemo.seleniumDemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setup() {
        driver.get("https://zalukaj.com/");
    }

    @Test
    public void checkCorrectLogin() {
        driver.findElement(By.name("login")).sendKeys("greek96");
        driver.findElement(By.name("password")).sendKeys("12348765");

        driver.findElement(By.xpath("//input[@value='Zaloguj']")).click();

        assertNotNull(driver.findElement(By.className("topnav")));
    }

    @Test
    public void checkBadLogin() {
        driver.findElement(By.name("login")).sendKeys("niema");
        driver.findElement(By.name("password")).sendKeys("zle");

        driver.findElement(By.xpath("//input[@value='Zaloguj']")).click();

        assertNotNull(driver.findElement(By.xpath("//input[@value='Zaloguj']")));
    }


    @AfterEach
    public void logout() {
        driver.get("https://zalukaj.com/wyloguj");
    }
}

