package packtpub.selenium.element.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Represents the account bar on the upper side of the website.
 *
 * @author jordi.roldan
 */
public class AccountBar {

    private WebElement logInRegisterDiv;

    private WebElement myAccountDiv;

    private LoginForm logInForm;

    /**
     * Constructor
     *
     * @param container HTML DOM element to be represented by this element.
     * */
    public AccountBar(WebElement container) {
        logInRegisterDiv = container.findElement(By.id("account-bar-login-register"));
        myAccountDiv = container.findElement(By.id("account-bar-logged-in"));
        logInForm = new LoginForm(container.findElement(By.id("packt-user-login-form")));
    }

    /**
     * @return true when there is a user logged in. False otherwise.
     * */
    public boolean isUserLoggedIn() {
        return myAccountDiv.isDisplayed();
    }

    /**
     * Performs the login using the given credentials and does wait until the user has been successfully logged in.
     *
     * @param mail the account email
     * @param password the account password
     * */
    public void logIn(String mail, String password) {
        logInForm.loginAndWait(mail, password);
    }

}
