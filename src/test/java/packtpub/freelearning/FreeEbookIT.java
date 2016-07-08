package packtpub.freelearning;

import org.junit.Before;
import org.junit.Test;
import packtpub.selenium.driver.DriverManager;
import packtpub.selenium.page.FreeLearningPage;

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

    private final String usernamePropertyName = "account.mail";
    private final String passwordPropertyName = "account.password";

    private DriverManager driverManager;

    private FreeLearningPage underTest;

    /**
     * Set up for the IT.
     * */
    @Before
    public void setUp() {
        driverManager = new DriverManager();
    }

    /**
     * Given that the user does provide valid credentials
     * When the free ebook is requested
     * It should load the book library
     * And the free ebook should be within the library
     * */
    @Test
    public void requestFreeEBook() {
        driverManager.loadPageAndWait(underTest);
        underTest.logIn(System.getProperty(usernamePropertyName), System.getProperty(passwordPropertyName));
    }
}
