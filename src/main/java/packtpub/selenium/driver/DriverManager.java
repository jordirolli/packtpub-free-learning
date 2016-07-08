package packtpub.selenium.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import packtpub.selenium.page.common.BasePage;
import packtpub.selenium.util.WebDriverFactory;

/**
 * Shared web driver to navigate to the different pages.
 *
 * @author jordi.roldan
 */
public class DriverManager {

    private final int timeoutInSecond = 5;

    private WebDriver driver;

    private WebDriverWait webDriverWait;

    /**
     * Constructor
     * */
    public DriverManager() {
        driver = WebDriverFactory.getWebdriver(WebDriverFactory.SupportedBrowser.CHROME);
        webDriverWait = new WebDriverWait(driver, timeoutInSecond);
    }

    /**
     * Loads the given page in the browser.
     *
     * @param page to be loaded
     * */
    public void loadPage(BasePage page) {
        driver.get(page.getUrl());
    }

    /**
     * Loads the given page in the browser and waits unit the page has been loaded.
     *
     * @param page to be loaded
     * */
    public void loadPageAndWait(final BasePage page) {
        driver.get(page.getUrl());
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getTitle().equals(page.getTitle());
            }
        });
    }
}
