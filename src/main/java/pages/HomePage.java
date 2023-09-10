package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	 private WebElement MyAccountDropDwn;
	
	@FindBy(linkText="Login")
	private WebElement loginOption ;
	
	@FindBy(linkText="Register")
	private WebElement registerOption ;
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void MyAccountDropDwnList() {
		elementUtils.clickOnElement(MyAccountDropDwn, 15);
	}
	
	public void SelectLoginOption() {
		elementUtils.clickOnElement(loginOption, 5);
	}	
	
	public void SelectRegistration() {
		registerOption.click();
	}
	
	public void enterProductIntoSearchBoxField(String validProductText) {
		elementUtils.typeTextIntoElement(searchBox, validProductText, 14);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
}
