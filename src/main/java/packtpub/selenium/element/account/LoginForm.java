package packtpub.selenium.element.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Web element representing the log in form. Notice that this form is displayed after clicking the 'Log in' button on
 * the account bar.
 *
 * @author jordi.roldan
 */
public class LoginForm {

    private WebElement emailInput;

    private WebElement passwordInput;

    private WebElement submitButton;

    /**
     * Constructor
     *
     * @param container HTML DOM element to be represented by this element.
     * */
    public LoginForm(WebElement container) {
        emailInput = container.findElement(By.id("email"));
        passwordInput = container.findElement(By.id("password"));
        submitButton = container.findElement(By.id("edit-submit-1"));
    }

    /**
     * Attempts to log in using the given credentials.
     *
     * @param username of the account.
     * @param password of the account.
     * */
    public void login(String username, String password) {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    /**
     * @return true if the log in form is visible.
     * */
    public boolean isVisible() {
        return emailInput.isDisplayed();
    }
}
