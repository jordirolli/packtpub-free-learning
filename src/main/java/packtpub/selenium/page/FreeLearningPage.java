package packtpub.selenium.page;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import packtpub.selenium.element.account.AccountBar;
import packtpub.selenium.page.account.MyEBooksPage;
import packtpub.selenium.page.common.BasePage;

import java.util.List;

/**
 * Page object for the <a href="https://www.packtpub.com/packt/offers/free-learning">free learning website</a>.
 *
 * @author jordi.roldan
 */
public class FreeLearningPage extends BasePage {

    private static final String FREE_LEARNING_URL = "https://www.packtpub.com/packt/offers/free-learning";
    private static final String FREE_LEARNING_TITLE = "Free Learning - Free Technology eBooks | PACKT Books";
    private static final String ACCOUNT_BAR_ELEMENT_ID = "account-bar";
    private static final String CLAIM_BOOK_INPUT_XPATH = ".//input[@value='Claim Your Free eBook']";

    private AccountBar accountBar;
    private WebElement claimFreeEBookInput;

    /**
     * Constructor
     *
     * @param webDriver web driver
     * @param webDriverWait web driver wait
     * */
    public FreeLearningPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait, FREE_LEARNING_URL, FREE_LEARNING_TITLE);
    }

    @Override
    public void initStaticElements(WebElement container) {
        accountBar = new AccountBar(getWebDriver(), getWebDriverWait(),
                container.findElement(By.id(ACCOUNT_BAR_ELEMENT_ID)));
        claimFreeEBookInput = getWebElement().findElement(By.xpath(CLAIM_BOOK_INPUT_XPATH));
    }

    /**
     * Performs the login using the given credentials and does wait until the user has been successfully logged in.
     *
     * @param mail the account email
     * @param password the account password
     * */
    public void logIn(String mail, String password) {
        hideAdvertOverlay();
        accountBar.logIn(mail, password);
        refreshPage();
    }

    /**
     * Claims the free eBook of the day.
     *
     * @return after claiming the free eBook of the day the user is redirected to the 'My eBooks' page.
     * */
    public MyEBooksPage claimFreeEBook() {
        claimFreeEBookInput.click();
        final MyEBooksPage redirectedPage = new MyEBooksPage(getWebDriver(), getWebDriverWait());
        redirectedPage.waitUntilLoaded();
        return redirectedPage;
    }

    private void hideAdvertOverlay() {
        WebDriver webDriver = getWebDriver();
        List<WebElement> advertOverlays = webDriver.findElements(By.tagName("w-div"));
        for (WebElement advertOverlay : advertOverlays) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.display = 'none';", advertOverlay);
        }
    }

}
