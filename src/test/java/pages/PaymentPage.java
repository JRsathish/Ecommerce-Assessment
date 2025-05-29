package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class PaymentPage extends BasePage {

	@FindBy(name = "name_on_card")
	WebElement nameOnCard;

	@FindBy(name = "card_number")
	WebElement cardNumber;

	@FindBy(name = "cvc")
	WebElement cvc;

	@FindBy(name = "expiry_month")
	WebElement expiryMonth;

	@FindBy(name = "expiry_year")
	WebElement expiryYear;

	@FindBy(xpath = "//button[text()='Pay and Confirm Order']")
	WebElement payAndConfirmOrder;

	@FindBy(xpath = "//p[contains(text(), 'Congratulations')]")
	WebElement orderConfirmationMsg;

	@FindBy(xpath = "//a[contains(text(),\"Continue\")]")
	WebElement continueButton;

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	public void enterPaymentDetails(String name, String card, String cvcVal, String month, String year) {
		nameOnCard.sendKeys(name);
		cardNumber.sendKeys(card);
		cvc.sendKeys(cvcVal);
		expiryMonth.sendKeys(month);
		expiryYear.sendKeys(year);
	}

	public void clickPayAndConfirmOrder() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payAndConfirmOrder);
		payAndConfirmOrder.click();
	}

	public boolean isOrderConfirmed() {
		return orderConfirmationMsg.isDisplayed();
	}

	public void continueButton() {
		continueButton.click();
	}
}
