package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class EcommerceTest {

	WebDriver driver;
	SignupLoginPage signupLoginPage;
	SignupDetailsPage signupDetailsPage;
	HomePage homePage;
	ProductsPage productsPage;
	CartPage cartPage;
	PaymentPage paymentPage;

	String email = "demo" + System.currentTimeMillis() + "@mail.com";
	String password = "Test@123";

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		homePage = new HomePage(driver);
		signupLoginPage = new SignupLoginPage(driver);
		signupDetailsPage = new SignupDetailsPage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		paymentPage = new PaymentPage(driver);
	}

	@Test
	public void testFullSignupLoginAndAddToCart() {
		homePage.clickSignupLogin();
		signupLoginPage.signUp("Demo User", email);
		signupDetailsPage.fillDetails(password);
		homePage.goToProducts();
		productsPage.searchProduct("Tshirt");
		productsPage.addFirstProductToCart();
		productsPage.viewCart();
		cartPage.proceedToCheckout();
		cartPage.placeOrder();

		paymentPage.enterPaymentDetails("Sathish Kumar", "4111111111111111", "123", "12", "2025");
		
		boolean isConfirmed = paymentPage.isOrderConfirmed();
		if (isConfirmed) {
		    System.out.println("✅ Order confirmation message is displayed. Test passed");
		} else {
		    System.out.println("❌ Order confirmation message is NOT displayed. Test failed");
		}
		
		paymentPage.continueButton();
		homePage.deleteButton();
		Assert.assertTrue(homePage.isDeleteConfirmed(), "Account delete confirmation message is NOT displayed!");
		homePage.continueButton();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
