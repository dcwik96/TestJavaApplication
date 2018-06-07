package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObjectAdd {

    @FindBy(css = "div#header > div.header-user > a.header-btn.js-open-add-menu > span.header-btn-icon.icon-lg.icon-add.light")
    WebElement addButton;

    private WebDriver webDriver;
    private PageObjectLogin pageObjectLogin;
    private final Wait<WebDriver> wait;

    public PageObjectAdd(WebDriver webDriver) throws InterruptedException {
        pageObjectLogin = PageFactory.initElements(webDriver, PageObjectLogin.class);
        pageObjectLogin.loginCorrect();

        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(webDriver, 100);
    }

    public void addTable() throws InterruptedException {
        addButton.click();
        webDriver.findElement(By.className("js-new-board")).click();
        webDriver.findElement(By.className("subtle-input")).sendKeys("nowaTablica");
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.primary")));
        webElement.click();
        Thread.sleep(10000);
    }

    public boolean assertAddTable() {
        return webDriver.getTitle().contains("nowaTablica | Trello");
    }
}
