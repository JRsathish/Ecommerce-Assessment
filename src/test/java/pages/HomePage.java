package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[normalize-space(text())=\"Signup / Login\"]")
	WebElement signupLoginLink;

	@FindBy(xpath = "//a[normalize-space(text())=\"Products\"]")
	WebElement productsLink;

	@FindBy(xpath = "//a[contains(text(),\"Delete Account\")]")
	WebElement deleteButton;

	@FindBy(xpath = "//p[contains(text(), 'Your account has been permanently deleted')]")
	WebElement deleteConfirmationMsg;
	
	@FindBy(xpath = "//a[contains(text(),\"Continue\")]")
	WebElement continueButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickSignupLogin() {
		signupLoginLink.click();
	}

	public void goToProducts() {
		productsLink.click();
	}

	public void deleteButton() {
		deleteButton.click();
	}

	public boolean isDeleteConfirmed() {
		return deleteConfirmationMsg.isDisplayed();
		
	}
	
	public void continueButton() {
		continueButton.click();
	}
	
}
