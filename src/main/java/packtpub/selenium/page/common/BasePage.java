package packtpub.selenium.page.common;


import org.openqa.selenium.By;
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
     * Initialize all the web elements of the page.
     *
     * @param container web element
     * */
    public abstract void init(WebElement container);

    /** @return url to load this page */
    public String getUrl() {
        return url;
    }

    /** @return title of the website once is loaded */
    public String getTitle() {
        return title;
    }

    /**
     * Loads the page in the web browser.
     * Notice that it performs an active wait and it does not return till the page is fully loaded on the web browser.
     * */
    public void loadPageAndWait() {
        getWebDriver().get(url);
        getWebDriverWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getTitle().equals(title);
            }
        });
        init(getWebDriver().findElement(By.tagName("html")));
    }
}
