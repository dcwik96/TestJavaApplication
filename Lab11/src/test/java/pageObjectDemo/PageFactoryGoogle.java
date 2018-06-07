package pageObjectDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryGoogle {
  
  //Nie uzywamy FindByElement !!!
	
  private WebElement q;
  public WebDriver driver;
  public WebDriverWait driverWait;
  
  public PageFactoryGoogle(WebDriver driver){
	  this.driver = driver;
	  driver.get("http://www.google.com/");
	  driverWait = new WebDriverWait(driver, 60);
  }
  
  public void search(String text) throws Exception{
	  q.sendKeys(text);
	  q.submit();
	  driverWait.until(ExpectedConditions.titleContains(text));
  }
  
  public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains("Mateusz Miotk");
		System.out.println(driver.getTitle());
		return(result);
	}
  
  
}
