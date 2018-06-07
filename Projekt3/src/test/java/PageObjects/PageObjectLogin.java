package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectLogin {

    @FindBy(id = "user")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    private static String LOGIN_URL = "https://trello.com/login";
    public WebDriver webDriver;
//    private final Wait<WebDriver> wait;

    public PageObjectLogin(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        this.webDriver = webDriver;
        webDriver.get(LOGIN_URL);
        wait = new WebDriverWait(webDriver, 100);
    }

    public void loginCorrect() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        userField.sendKeys("spampoczta1@interia.pl");
        passwordField.sendKeys("asdf1234");

        loginButton.submit();
        Thread.sleep(1000);
    }

    public void loginWrong() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        userField.sendKeys("zledane");
        passwordField.sendKeys("zlehaslo");

        loginButton.submit();
        Thread.sleep(1000);
    }

    public boolean assertCorrectLogin() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        WebElement webElement = wait.until(x -> x.findElement(By.className("member-initials")));
        return webElement.isDisplayed();
    }

    public boolean assertWrongLogin() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        WebElement webElement = wait.until(x -> x.findElement(By.id("error")));
        return webElement.isDisplayed();

    }
}
