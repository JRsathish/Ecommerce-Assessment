package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

	@FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
	WebElement proceedToCheckout;

	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	WebElement placeOrder;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public void proceedToCheckout() {
		proceedToCheckout.click();
	}

	public void placeOrder() {
		new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(placeOrder));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrder);
		placeOrder.click();
	}
}
