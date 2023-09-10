package StepDefinations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchResultPage;
import pages.WarningMessagesPage;
import utils.CommonUtils;

public class Registration {
	
	WebDriver driver;
	
	RegisterPage RegisterPg;
	HomePage HomePg;
	AccountSuccessPage AccountSuccessPg;
	WarningMessagesPage WarningMessagePg;
	
	@Given("User navigates to Registration Account page")
	public void user_navigates_to_registration_account_page() {
	    driver = DriverFactory.getDriver();
	    
	    // Initialize all the objects
	    HomePg = new HomePage(driver);
		WarningMessagePg = new WarningMessagesPage(driver);
		AccountSuccessPg = new AccountSuccessPage(driver);
		RegisterPg = new RegisterPage(driver);
        
        HomePg.MyAccountDropDwnList();
	    HomePg.SelectRegistration();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		RegisterPg.enterFirstNameField(dataMap.get("firstName"));
		RegisterPg.enterLastName(dataMap.get("lastName"));
		RegisterPg.enterEmail(CommonUtils.getEmailWithTimeStamp());
		RegisterPg.enterTelephoneNumber(dataMap.get("telephone"));
		RegisterPg.enterPasswordField(dataMap.get("password"));
		RegisterPg.enterConfirmedPassword(dataMap.get("password"));
		
	} 
	
	@When("User enters the details into below fields with the duplicate email")
	public void user_enters_the_details_into_below_fields_with_the_duplicate_email(DataTable dataTable) {
Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
		
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		RegisterPg.clickOnPrivacyPolicy();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		RegisterPg.clickOnContinueButton();
	}

	@Then("User account should created successfully")
	public void user_account_should_created_successfully() {
	    Assert.assertEquals("Your Account Has Been Created!", AccountSuccessPg.getPageHeading());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		RegisterPg.clickForYesNewsletter();
	}

	@Then("User should get a proper warning about duplicate emali")
	public void user_should_get_a_proper_warning_about_duplicate_emali() {
	    Assert.assertTrue(WarningMessagePg.warningForDuplicateEmail().contains("Warning: E-Mail Address is already registered!"));
	}
	
	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	    //Intentionally kept blank
	}

	@Then("User should get a proper warning message for mandatory field")
	public void user_should_get_a_proper_warning_message_for_mandatory_field() {
		
		Assert.assertTrue(WarningMessagePg.warningForDuplicateEmail().contains("Warning: You must agree to the Privacy Policy!"));
		
		Assert.assertEquals("First Name must be between 1 and 32 characters!", WarningMessagePg.firstNameWarningMessage());
		
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", WarningMessagePg.lastNameWarningMessage());
		
		Assert.assertEquals("E-Mail Address does not appear to be valid!", WarningMessagePg.emailWarningMessage());
		
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", WarningMessagePg.telephoneWarningMessage());
		
		Assert.assertEquals("Password must be between 4 and 20 characters!", WarningMessagePg.passwordWarningMessages());
	}

}
