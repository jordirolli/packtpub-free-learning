package packtpub.selenium.page;

import org.openqa.selenium.WebElement;
import packtpub.selenium.element.account.AccountBar;
import packtpub.selenium.page.common.BasePage;

/**
 * Page object for the <a href="https://www.packtpub.com/packt/offers/free-learning">free learning website</a>.
 *
 * @author jordi.roldan
 */
public class FreeLearningPage extends BasePage {

    private static final String FREE_LEARNING_URL = "https://www.packtpub.com/packt/offers/free-learning";
    private static final String FREE_LEARNING_TITLE = "Free Learning - Free Technology eBooks | PACKT Books";

    private AccountBar accountBar;

    /**
     * Constructor
     *
     * @param container HTML DOM element to be represented by this page object.
     * */
    public FreeLearningPage(WebElement container) {
        super(FREE_LEARNING_URL, FREE_LEARNING_TITLE);
        accountBar = new AccountBar(container);
    }

    /**
     * Performs the login using the given credentials and does wait until the user has been successfully logged in.
     *
     * @param mail the account email
     * @param password the account password
     * */
    public void logIn(String mail, String password) {
        if (!accountBar.isUserLoggedIn()) {
            accountBar.logIn(mail, password);
        }
    }

}
