package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupLoginPage extends BasePage {

	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement signupName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement signupEmail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signupButton;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement loginEmail;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement loginPassword;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement loginButton;

	public SignupLoginPage(WebDriver driver) {
		super(driver);
	}

	public void signUp(String name, String email) {
		signupName.sendKeys(name);
		signupEmail.sendKeys(email);
		signupButton.click();
	}

	public void login(String email, String password) {
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		loginButton.click();
	}
}
