package packtpub.freelearning;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import packtpub.selenium.page.FreeLearningPage;
import packtpub.selenium.webdriver.WebDriverFactory;

/**
 *
 * Tests to execute on <a href="https://www.packtpub.com/packt/offers/free-learning">packt publishing free learning</a>
 * website.
 *
 * @author jordi.roldan
 */
public class FreeEBookIT{

    /* TODO
     * Ensure that the webdriver is properly loaded.
     * PhantomJS
     * Spring injection
     */
    private static final int TIMEOUT_IN_SECONDS = 5;

    private final String usernamePropertyName = "account.mail";
    private final String passwordPropertyName = "account.password";

    private WebDriver driver;
    private FreeLearningPage underTest;

    /**
     * Set up for the IT.
     * */
    @Before
    public void setUp() {
        driver = WebDriverFactory.getWebdriver(WebDriverFactory.SupportedBrowser.CHROME);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        underTest = new FreeLearningPage(driver, wait);
    }

    /**
     * Tear down for the IT.
     * */
    @After
    public void tearDown() {
        driver.close();
    }

    /**
     * Given that the user does provide valid credentials
     * When the free ebook is requested
     * It should load the book library
     * And the free ebook should be within the library
     * */
    @Test
    public void requestFreeEBook() {
        underTest.loadPageAndWait();
        underTest.logIn(System.getProperty(usernamePropertyName), System.getProperty(passwordPropertyName));
    }
}
