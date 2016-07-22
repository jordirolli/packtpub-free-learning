package packtpub.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class providing basic properties for dealing with {@link WebDriver}.
 *
 * @author jordi.roldan
 */
public class AbstractWebDriverComponent {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    /**
     * Constructs a new AbstractWebDriverComponent.
     * @param webDriver the webDriver to back this component
     * @param webDriverWait the waitUtil instance for this component
     */
    public AbstractWebDriverComponent(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    /**
     * Gets the webDriver.
     * @return the webDriver
     */
    protected WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets the waitUtil.
     * @return the waitUtil
     */
    protected WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
