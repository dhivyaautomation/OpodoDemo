package stepDefinitions;

import com.qa.factory.DriverFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.FlightDetailsPage;
import com.pages.SearchFlightPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlightsSteps extends DriverFactory {

	private SearchFlightPage SearchFlightPage = new SearchFlightPage(DriverFactory.getDriver());

	@Given("User is in the search flights page")
	public void user_is_in_the_search_flights_page() {
		DriverFactory.getDriver().get("http://opodo.co.uk");
		SearchFlightPage.acceptCondition();
	}

	@When("user performs search with information for {string},{string},{string} and {string}")
	public void userSearch(String departure, String destination,String start_date,String end_date ) {
		SearchFlightPage.enterTo(destination);
		SearchFlightPage.enterFrom(departure); 
		SearchFlightPage.chooseReturnDate(end_date);
		SearchFlightPage.chooseStartDate(start_date);
	}


	@Then("user lands in results screen to check availability of flights")
	public void toCheckResultsDisplayed() {
		boolean result = SearchFlightPage.checkSearchResults();
		Assert.assertEquals(result, true);
	}

	@When ("user selects {string} and {string}")
	public void userSelectWayAndClass(String way, String eclass) {
		SearchFlightPage.chooseWay(way);
		SearchFlightPage.chooseClass(eclass);
	}

	@When  ("user performs search with data for {string},{string} and {string}")
	public void userSelectsDataforTrip(String from,String to, String stDate) {
		SearchFlightPage.enterTo(to);
		SearchFlightPage.enterFrom(from); 
		SearchFlightPage.chooseStartDate(stDate);
	}
}
