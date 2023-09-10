package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement emailField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(id="input-confirm")
	WebElement passwordConfirmField;
	
	@FindBy(id="input-telephone")
	WebElement telephoneField;
	
	@FindBy(name = "agree")
	WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	WebElement YesNewslatterOption;
	
	public void enterFirstNameField(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneNumber(String telephoneNumber) {
		telephoneField.sendKeys(telephoneNumber);
	}
	
	public void enterPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void enterConfirmedPassword(String confirmPassword) {
		passwordConfirmField.sendKeys(confirmPassword);
	}
	
	public void clickOnPrivacyPolicy() {
		privacyPolicyOption.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public void clickForYesNewsletter() {
		YesNewslatterOption.click();
	}
	
	
}
