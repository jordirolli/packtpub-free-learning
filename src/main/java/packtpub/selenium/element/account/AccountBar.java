package packtpub.selenium.element.account;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import packtpub.selenium.webdriver.AbstractWebDriverComponent;

/**
 * Represents the account bar on the upper side of the website.
 *
 * @author jordi.roldan
 */
public class AccountBar extends AbstractWebDriverComponent {

    private WebElement logInRegisterDiv;

    private WebElement myAccountDiv;

    private LoginForm logInForm;

    /**
     * Constructor
     * @param webDriver web driver
     * @param webDriverWait web driver wait
     * @param container HTML DOM element to be represented by this element.
     * */
    public AccountBar(WebDriver webDriver, WebDriverWait webDriverWait, WebElement container) {
        super(webDriver, webDriverWait);
        logInRegisterDiv = container.findElement(By.id("account-bar-login-register"));
        myAccountDiv = container.findElement(By.id("account-bar-logged-in"));
        logInForm = new LoginForm(container.findElement(By.id("packt-user-login-form")));
    }

    /**
     * Performs the login using the given credentials and does wait until the user has been successfully logged in.
     *
     * @param mail the account email
     * @param password the account password
     * */
    public void logIn(String mail, String password) {
        if (!isUserLoggedIn()) {
            if (logInRegisterDiv.isDisplayed()) {
                ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();",
                        logInRegisterDiv.findElement(By.className("login-popup")));
                getWebDriverWait().until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return logInForm.isVisible();
                    }
                });
                logInForm.login(mail, password);
            }
        }
    }

    private boolean isUserLoggedIn() {
        return myAccountDiv.isDisplayed();
    }

}
