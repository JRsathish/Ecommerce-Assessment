package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupDetailsPage extends BasePage {

	@FindBy(id = "id_gender1")
	WebElement genderMr;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "days")
	WebElement dayDropdown;

	@FindBy(id = "months")
	WebElement monthDropdown;

	@FindBy(id = "years")
	WebElement yearDropdown;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "mobile_number")
	WebElement mobileNumber;

	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement createAccountButton;

	@FindBy(xpath = "//a[text()=\"Continue\"]")
	WebElement continueButton;

	public SignupDetailsPage(WebDriver driver) {
		super(driver);
	}

	public void fillDetails(String pwd) {
		genderMr.click();
		password.sendKeys(pwd);
		new Select(dayDropdown).selectByVisibleText("16");
		new Select(monthDropdown).selectByVisibleText("February");
		new Select(yearDropdown).selectByVisibleText("2002");

		firstName.sendKeys("Sathish");
		lastName.sendKeys("kumar");
		address.sendKeys("123 Main Street");
		state.sendKeys("CA");
		city.sendKeys("Los Angeles");
		zipcode.sendKeys("90001");
		mobileNumber.sendKeys("8838788654");

		createAccountButton.click();
		continueButton.click();

	}
}
