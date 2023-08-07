package stepDefinitions;

import org.testng.Assert;
import com.pages.SummaryPage;
import com.pages.SearchFlightPage;
import com.qa.factory.DriverFactory;

import com.pages.FlightDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FlightDetailSteps{
	
	private SearchFlightPage SearchFlightPage = new SearchFlightPage(DriverFactory.getDriver());
	private FlightDetailsPage FlightDetailsPage;
	private SummaryPage SummaryPage;



	@And("user clicks on Search flights")
	public void user_clicks_on_search_flights() {
		FlightDetailsPage =  SearchFlightPage.clickSearchFlight(); 
	}
}
