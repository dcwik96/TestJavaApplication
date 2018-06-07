package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObjectSearch {

    @FindBy(className = "header-search-input")
    private WebElement searchInput;

    private WebDriver webDriver;
    private PageObjectLogin pageObjectLogin;
    private final Wait<WebDriver> wait;

    public PageObjectSearch (WebDriver webDriver) throws InterruptedException {
        pageObjectLogin = PageFactory.initElements(webDriver, PageObjectLogin.class);
        pageObjectLogin.loginCorrect();

        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 10);
    }

    public void search(String searchSeq) throws InterruptedException {
        searchInput.sendKeys(searchSeq);
        Thread.sleep(10000);
    }

    public boolean assertNothingFound(){
        WebElement webElement = wait.until(x -> x.findElement(By.className("search-results-view")));
        System.out.println(webElement.getText());
        return webElement.getText().contains("Nie znaleźliśmy żadnych kart");
    }








}
