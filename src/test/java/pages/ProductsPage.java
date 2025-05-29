package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

	String productNameElement;

	@FindBy(id = "search_product")
	WebElement searchBox;

	@FindBy(id = "submit_search")
	WebElement searchButton;

	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	WebElement addToCart;

	@FindBy(xpath = "//u[contains(text(),'View Cart')]")
	WebElement viewCart;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void searchProduct(String productName) {
		searchBox.sendKeys(productName);
		searchButton.click();
	}

	public void addFirstProductToCart() {
		addToCart.click();
	}

	public void viewCart() {
		new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(viewCart))
				.click();
	}
}
