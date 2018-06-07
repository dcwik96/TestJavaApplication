package pageObjectDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjectLoginObjects {
	
	
	@FindBy(name = "login")
	private WebElement login;

	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Zaloguj']")
	private WebElement button;
	
	@FindBy(className = "topnav")
	private WebElement topNav;
	
	public WebDriver driver;
	
	public PageObjectLoginObjects(WebDriver driver){
		this.driver = driver;
		this.driver.get("https://zalukaj.com/");
	}

	public void login() throws Exception {
		login.sendKeys("greek96");
        password.sendKeys("12348765");

        button.submit();
		Thread.sleep(1000);
	}
	
	public boolean assertPositiveLogin() {
		if(topNav == null) return false;
		else return true;
	}

}
