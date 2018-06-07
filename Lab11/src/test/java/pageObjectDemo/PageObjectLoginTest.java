package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectLoginTest {

	
	public WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws Exception {
		PageObjectLoginObjects loginObjects = PageFactory.initElements(driver, PageObjectLoginObjects.class);
		loginObjects.login();
		
		assertTrue(loginObjects.assertPositiveLogin());
	}
	
}