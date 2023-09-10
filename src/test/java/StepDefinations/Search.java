package StepDefinations;

import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchResultPage;
import pages.WarningMessagesPage;

public class Search {
	WebDriver driver;

	public HomePage HomePg;
	public SearchResultPage SearchResultPg;
	public WarningMessagesPage WarningMessagePg;

	@Given("User opens application")
	public void user_opens_application() {

		driver = DriverFactory.getDriver();
		
		HomePg = new HomePage(driver);
		SearchResultPg = new SearchResultPage(driver);
		WarningMessagePg = new WarningMessagesPage(driver);


	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		// Initialize the homePg object

		HomePg.enterProductIntoSearchBoxField(validProductText);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		HomePg.clickOnSearchButton();
	}

	@Then("User should get valid product displayed in search result")
	public void user_should_get_valid_product_displayed_in_search_result() {

		Assert.assertTrue(SearchResultPg.getValidProductDisplayed());
	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		HomePg.enterProductIntoSearchBoxField(invalidProductText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.",
				WarningMessagePg.noProductMatchingWarningMessage());
	}

	@When("User dont enters any product name into search box field")
	public void user_dont_enters_any_product_name_into_search_box_field() {
		// Intentionally leave blank
		HomePg.clickOnSearchButton();
	}

}
