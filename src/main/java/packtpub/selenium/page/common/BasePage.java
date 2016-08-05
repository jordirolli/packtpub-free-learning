package packtpub.selenium.page.common;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import packtpub.selenium.webdriver.AbstractWebDriverComponent;

/**
 * Base class for the page object implementations. All the page objects should extend this base class.
 *
 * @author jordi.roldan
 */
public abstract class BasePage extends AbstractWebDriverComponent {

    private String url;

    private String title;

    private WebElement webElement;

    /**
     * Constructor
     *
     * @param webDriver web driver
     * @param webDriverWait web driver wait
     * @param url of the website represented by the page object.
     * @param title of the website represented by the page object.
     * */
    protected BasePage(WebDriver webDriver, WebDriverWait webDriverWait, String url, String title) {
        super(webDriver, webDriverWait);
        this.url = url;
        this.title = title;
    }

    /**
     * Initialize static web elements of the page.
     *
     * @param container web element
     * */
    public abstract void initStaticElements(WebElement container);

    /** @return url to load this page */
    public String getUrl() {
        return url;
    }

    /** @return title of the website once is loaded */
    public String getTitle() {
        return title;
    }

    /** @return web element representing DOM structure for current page */
    public WebElement getWebElement() {
        return webElement;
    }

    /**
     * Loads the page in the web browser.
     * Notice that it performs an active wait and it does not return till the page is fully loaded on the web browser.
     * */
    public void loadPageAndWait() {
        getWebDriver().get(url);
        waitUntilLoaded();
    }

    /**
     * Restores the web elements of the page after the page does refresh.
     * Notice that web elements initialised before the DOM refreshes become stale.
     * */
    public void refreshPage() {
        // This action triggers a page reload so we have to re-initialise the web elements as the previous
        // ones become stale
        getWebDriverWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                try {
                    getWebElement().findElement(By.id("DOES_NOT_MATTER"));
                    return false;
                } catch (StaleElementReferenceException exception) {
                    return true;
                }
            }
        });
        waitUntilLoaded();
    }

    /**
     * Wait until the page is loaded in the web browser. Notice that it performs an active wait.
     * */
    public void waitUntilLoaded() {
        getWebDriverWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getTitle().equals(title);
            }
        });
        webElement = getWebDriver().findElement(By.tagName("html"));
        initStaticElements(webElement);
    }
}
