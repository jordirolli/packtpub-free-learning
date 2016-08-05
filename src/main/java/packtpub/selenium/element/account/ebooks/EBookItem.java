package packtpub.selenium.element.account.ebooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import packtpub.selenium.webdriver.AbstractWebDriverComponent;

/**
 * Represents ebook item within the list of 'My eBooks'.
 *
 * <div class="product-line unseen" nid="17514" title="HBase Design Patterns [eBook]">
 *    <div class="product-top-line">
 *        <div class="float-left product-thumbnail toggle" style="display:none">
 *           <a href="/big-data-and-business-intelligence/hbase-design-patterns">
 *              <img src="..." alt="..." title="..." width="94" height="116" data-original="....jpg"
 *               class="imagecache imagecache-thumbview" style="opacity: 1;">
 *          </a>
 *       </div>
 *       <div class="float-left product-info">
 *          <div class="title"> HBase Design Patterns [eBook]</div>
 *          <div class="author"><br></div>
 *          <div class="toggle" style="display:none">
 *              <table class="product-reference-table">
 *                  <tbody>
 *                      <tr><th class="price-column">Price</th><th>Order Reference</th><th>Order Date</th></tr>
 *                      <tr><td>€0.00</td><td>PAC-16-9912076-1073685</td><td>04/08/16</td></tr>
 *                  </tbody>
 *              </table>
 *          </div>
 *      </div>
 *      <div class="float-right toggle-product-line">+</div>
 *  </div>
 *  <div class="product-buttons-line toggle" style="display:none">
 *      <div class="download-container cf">...</div>
 *          <div class="download-container cf ">
 *              <a href="/ebook_download/17514/pdf"></a>
 *              <a href="/ebook_download/17514/epub"></a>
 *              <a href="/ebook_download/17514/mobi"></a>
 *              <a href="/code_download/17515"></a>
 *              <a href="#" class="kindle-link" nid="17515"></a>
 *          </div>
 *      </div>
 *  </div>
 *
 * @author jordi.roldan
 */
public class EBookItem extends AbstractWebDriverComponent {

    private int id;
    private String title;

    /**
     * Constructor
     * @param webDriver web driver
     * @param webDriverWait web driver wait
     * @param container HTML DOM element to be represented by this element.
     * */
    public EBookItem(WebDriver webDriver, WebDriverWait webDriverWait, WebElement container) {
        super(webDriver, webDriverWait);
        id = Integer.parseInt(container.getAttribute("nid"));
        title = container.getAttribute("title");
    }

    /** @return packtpub id for the ebook */
    public int getId() {
        return id;
    }

    /** @return title of the ebook */
    public String getTitle() {
        return title;
    }
}
