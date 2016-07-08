package packtpub.selenium.page.common;


/**
 * Base class for the page object implementations. All the page objects should extend this base class.
 *
 * @author jordi.roldan
 */
public class BasePage {

    private String url;

    private String title;

    /**
     * Constructor
     *
     * @param url of the website represented by the page object.
     * @param title of the website represented by the page object.
     * */
    protected BasePage(String url, String title) {
        this.url = url;
        this.title = title;
    }

    /** @return url to load this page */
    public String getUrl() {
        return url;
    }

    /** @return title of the website once is loaded */
    public String getTitle() {
        return title;
    }
}
