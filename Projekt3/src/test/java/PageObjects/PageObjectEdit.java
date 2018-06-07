package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObjectEdit {

    @FindBy(css = ".button-link")
    WebElement editButton;

    private WebDriver webDriver;
    private PageObjectLogin pageObjectLogin;
    private final Wait<WebDriver> wait;

    public PageObjectEdit(WebDriver webDriver) throws InterruptedException {
        pageObjectLogin = PageFactory.initElements(webDriver, PageObjectLogin.class);
        pageObjectLogin.loginCorrect();

        this.webDriver = webDriver;
        webDriver.get("https://trello.com/test57467856");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 10);
    }

    public void edit(String editSeq) throws InterruptedException {
        editButton.click();
        webDriver.findElement(By.name("bio")).clear();
        webDriver.findElement(By.name("bio")).sendKeys("nowebio");
        webDriver.findElement(By.cssSelector(".primary")).submit();

        Thread.sleep(1000);
    }

    public boolean assertChangedTitle(String editSeq) {
        return webDriver.findElement(By.cssSelector(".tabbed-pane-header-details-content")).getText().contains("nowebio");
    }


}