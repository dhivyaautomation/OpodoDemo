package stepDefinitions;

import org.junit.Assert;

import com.pages.FlightDetailsPage;
import com.pages.SearchFlightPage;
import com.pages.SummaryPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SummarySteps  {
//	private SearchFlightPage SearchFlightPage = new SearchFlightPage(DriverFactory.getDriver());
	private FlightDetailsPage FlightDetailsPage = new FlightDetailsPage((DriverFactory.getDriver()));
	private SummaryPage SummaryPage;

	@And ("user selects best cheapest flight option")
		public void selectOption() {
		SummaryPage = FlightDetailsPage.chooseRate();
		}

	@When ("user navigates to Summary page")
	public void checkUserInSummaryPage() {
		boolean result;
		result = SummaryPage.checkUserInSummaryPage();
		Assert.assertEquals(true, result);
	}

	@Then ("user selects and verifies {string} type")
	public void selectAndVerifySeat(String seat) {
		SummaryPage.chooseseat(seat);
	}

}
