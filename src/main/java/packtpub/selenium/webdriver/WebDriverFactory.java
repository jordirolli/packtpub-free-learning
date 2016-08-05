package packtpub.selenium.webdriver;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.StringWriter;

/**
 * Factory to build the selenium web driver based on the underlying OS the app is running from.
 *
 * More information regarding the
 * <a href="https://en.wikipedia.org/wiki/Factory_%28object-oriented_programming%29">Factory Pattern</a>
 *
 * @author jordi.roldan
 */
public final class WebDriverFactory {

    private static final String BIN_BASE_PATH = "/webdriver/";
    private static final String CHROME_WEB_DRIVER_BIN_FILE_NAME = "chromedriver";
    private static final String CHROME_WEB_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";

    private WebDriverFactory() { }

    /**
     * Supported browsers.
     * */
    public enum SupportedBrowser {
        /** Google Chrome */
        CHROME("chrome");

        private String path;

        /**
         * Constructor
         *
         * @param path under which the web driver is stored
         * */
        SupportedBrowser(String path) {
            this.path = path;
        }

        /**
         * @return path under which the web driver is stored
         * */
        public String getPath() {
            return path;
        }

    }

    /**
     * Supported OS.
     * */
    private enum SupportedOS {
        MAC("mac"),
        LINUX("linux"),
        WINDOWS("win");

        private String path;

        /**
         * Constructor
         *
         * @param path under which the web driver is stored
         * */
        SupportedOS(String path) {
            this.path = path;
        }

        /**
         * @return path under which the web driver is stored
         * */
        public String getPath() {
            return path;
        }

        /**
         * @return current OS
         * */
        public static SupportedOS getCurrentOS() {
            if (SystemUtils.IS_OS_MAC_OSX) {
                return MAC;
            } else if (SystemUtils.IS_OS_LINUX) {
                return LINUX;
            } else if (SystemUtils.IS_OS_WINDOWS) {
                return WINDOWS;
            }
            return null;
        }
    }

    /**
     * Returns the Chrome Driver.
     *
     * @param browser the browser to execute.
     *
     * @return the Chrome Driver
     */
    public static WebDriver getWebdriver(SupportedBrowser browser) {
        StringWriter driverPathWriter = new StringWriter();
        driverPathWriter.write(BIN_BASE_PATH + browser.getPath() + "/");
        switch (browser) {
            case CHROME:
                driverPathWriter.append(SupportedOS.getCurrentOS().getPath() + "/");
                driverPathWriter.append(CHROME_WEB_DRIVER_BIN_FILE_NAME);
                String webDriverRelativePath = driverPathWriter.toString();
                String webDriverAbsolutePath = WebDriverFactory.class.getResource(webDriverRelativePath).getFile();
                //Permission webDriverExecPermission = new java.io.FilePermission(webDriverAbsolutePath, "execute");
                //webDriverExecPermission
                File driver = new File(webDriverAbsolutePath);
                if (!driver.canExecute()) {
                    driver.setExecutable(true);
                }
                System.setProperty(CHROME_WEB_DRIVER_PROPERTY_NAME, webDriverAbsolutePath);
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(CHROME_WEB_DRIVER_PROPERTY_NAME, webDriverAbsolutePath);
                return new ChromeDriver(capabilities);
            default:
                return null;
        }
    }
}
