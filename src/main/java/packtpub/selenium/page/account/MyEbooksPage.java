package packtpub.selenium.page.account;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import packtpub.selenium.element.account.ebooks.EBookItem;
import packtpub.selenium.page.common.BasePage;

import java.util.List;

/**
 * Page object for the <a href="https://www.packtpub.com/account/my-ebooks">Account -> My eBooks website</a>.
 *
 * @author jordi.roldan
 */
public class MyEBooksPage extends BasePage {

    private static final String MY_E_BOOKS_URL = "https://www.packtpub.com/account/my-ebooks";
    private static final String MY_E_BOOKS_TITLE = "Packt Publishing | Technology Books, eBooks & Videos";
    private static final String MY_E_BOOKS_LIST_ELEMENT_ID = "product-account-list";
    private static final String E_BOOK_ITEM_XPATH = ".//div[@nid]";

    private List<EBookItem> myEBooks = Lists.newArrayList();

    /**
     * Constructor
     * @param webDriver web driver
     * @param webDriverWait web driver wait
     * */
    public MyEBooksPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait, MY_E_BOOKS_URL, MY_E_BOOKS_TITLE);
    }

    /**
     * Initialize all the web elements of the page.
     *
     * @param container web element
     */
    @Override
    public void initStaticElements(WebElement container) {
        WebElement listWrapper = container.findElement(By.id(MY_E_BOOKS_LIST_ELEMENT_ID));
        List<WebElement> eBooksAsWebElements =  listWrapper.findElements(By.xpath(E_BOOK_ITEM_XPATH));
        for (WebElement eBookAsWebElement : eBooksAsWebElements) {
            myEBooks.add(new EBookItem(getWebDriver(), getWebDriverWait(), eBookAsWebElement));
        }
    }

    /** @return list of eBooks on current account */
    public List<EBookItem> getMyEBooks() {
        return myEBooks;
    }
}
