import PageObjects.PageObjectAdd;
import PageObjects.PageObjectEdit;
import PageObjects.PageObjectLogin;
import PageObjects.PageObjectSearch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrelloTest {

    private static WebDriver webDriver;

    private PageObjectLogin pageObjectLogin;
    private PageObjectSearch pageObjectSearch;
    private PageObjectAdd pageObjectAdd;
    private PageObjectEdit pageObjectEdit;

    @BeforeEach
    public void setUp() {
        webDriver = BrowserManager.initializeBrowser(webDriver, "Firefox");
//        webDriver = BrowserManager.initializeBrowser(webDriver, "Phantom");
//        webDriver = BrowserManager.initializeBrowser(webDriver, "Explorer");
//        webDriver = BrowserManager.initializeBrowser(webDriver, "Opera");
//        webDriver = BrowserManager.initializeBrowser(webDriver, "Chrome");


    }

    @Test
    public void checkIfLoginCorrect() throws InterruptedException {
        pageObjectLogin = PageFactory.initElements(webDriver, PageObjectLogin.class);
        pageObjectLogin.loginCorrect();
        assertTrue(pageObjectLogin.assertCorrectLogin());
    }

    @Test
    public void checkIfWrongLogin() throws InterruptedException {
        pageObjectLogin = PageFactory.initElements(webDriver, PageObjectLogin.class);
        pageObjectLogin.loginWrong();
        assertTrue(pageObjectLogin.assertWrongLogin());
    }

    @Test
    public void checkIfProperSearch() throws InterruptedException {
        pageObjectSearch = PageFactory.initElements(webDriver, PageObjectSearch.class);
        pageObjectSearch.search("asdf");
        assertFalse(pageObjectSearch.assertNothingFound());
    }

    @Test
    public void checkIfNothingFoundSearch() throws InterruptedException {
        pageObjectSearch = PageFactory.initElements(webDriver, PageObjectSearch.class);
        pageObjectSearch.search("asdfaaaaaaaa");
        assertTrue(pageObjectSearch.assertNothingFound());
    }

    @Test
    public void checkAdd() throws InterruptedException {
        pageObjectAdd = PageFactory.initElements(webDriver, PageObjectAdd.class);
        pageObjectAdd.addTable();

        assertTrue(pageObjectAdd.assertAddTable());
    }

    @Test
    public void checkEdit() throws InterruptedException {
        pageObjectEdit = PageFactory.initElements(webDriver, PageObjectEdit.class);
        pageObjectEdit.edit("NowyTytul");
        assertTrue(pageObjectEdit.assertChangedTitle("NowyTytul"));

    }


    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
