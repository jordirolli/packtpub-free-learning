package packtpub.selenium.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by jordi.roldan on 8/07/2016.
 */
public final class WebDriverFactory {

    private static final String BIN_BASE_PATH = "bin/webdriver/";

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
                driverPathWriter.append("chromedriver");
                String webDriverBinaryPath = driverPathWriter.toString();
                // TODO Ensure that the file has execute permissions
                /*
                File driver = new File(WebDriverFactory.class.getResource(webDriverBinaryPath).getFile());
                if (!driver.canExecute()) {
                    driver.setExecutable(true);
                }
                */
                System.setProperty("webdriver.chrome.driver", webDriverBinaryPath);
                Map<String, Object> chromeOptions = Maps.newHashMap();
                chromeOptions.put("binary", webDriverBinaryPath);
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                return new ChromeDriver(capabilities);
            default:
                return null;
        }
    }
}
