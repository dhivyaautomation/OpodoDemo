package com.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchFlightPage {

	private WebDriver driver;
	private WebDriverWait wt;

	// By Locators : Object repo
	By AgreeClosebtn = By.id("didomi-notice-agree-button");
	By From          = By.xpath("//input[contains(@placeholder,'Where from?')]");
	By To            = By.xpath("//input[contains(@placeholder,'Where to?')]");
	By Returnbox     = By.xpath("//input[contains(@placeholder,'Return')]");
	By Departure     = By.xpath("//input[contains(@placeholder,'Departure')]");
	By donebtn       = By.xpath("(//div[@class='odf-flex-item odf-flex-item-sm'])[3]");
	By SearchFlight  = By.xpath("//div[@class='FlightsManagerFooterCTA']/button");
	By resultsShown  = By.xpath("//*[@class='css-hty8f5-Box-BaseFlex e12411730']");
	By one_way       = By.xpath("(//*[@class='odf-flex-item'])[2]");
	By multiCity     = By.xpath("(//*[@class='odf-flex-item'])[3]");
	By classLink     = By.xpath("//*[@class=\"odf-col odf-stroke-primary-right odf-space-outer-right-m \"]");
	By searchFlight1 = By.xpath("//div[@class='odf-space-inner-right-xl FlightsManagerFooterCTA']/button");


	//constructer of page class
	public SearchFlightPage(WebDriver driver) {
		this.driver=driver;
	}

	//From departure
	public void enterFrom(String from) {
		wt = new WebDriverWait(driver,20);
		WebElement departure =  wt.until(ExpectedConditions.elementToBeClickable(From));
		departure.sendKeys(from);

		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class=\"odf-box odf-box-layer odf-popup odf-popup-flex odf-space-outer-top-xs opened css-5ofyg9\"]/ul//li"));
		for (WebElement dep : list1) {
			String departureElement = dep.getText();
			System.out.println(departureElement	);
			if(departureElement.contains(from)) {
				dep.click();
				break;
			}
		}
	}

	//To arrival
	public void enterTo(String destination) {
		wt = new WebDriverWait(driver,40);
		WebElement arrive = wt.until(ExpectedConditions.elementToBeClickable(To));
		arrive.sendKeys(destination);
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='odf-box odf-box-layer odf-popup odf-popup-flex odf-space-outer-top-xs opened css-5ofyg9']/ul//li"));	

		for (WebElement arr : list2) {
			String arriveElement = arr.getText();
			System.out.println(arriveElement);
			if(arriveElement.contains(destination)) {
				arr.click();
				break;
			}
		}
	}

	
	public String splitDay(String DateIs) {
		String date = DateIs;
		int pos1 = date.indexOf(" "); //2
		int pos2 = date.indexOf(" ",pos1+1); //9
		String day = date.substring(0,pos1);
		System.out.println("day = " + day);
		return day;
	}

	public String splitMonthYear(String DateIs) {
		String date = DateIs;
		int pos1 = date.indexOf(" "); //2
		int pos2 = date.indexOf(" ",pos1+1); //9
		String month_year = date.substring(pos1+1,date.length());
		System.out.println("month_year = "+ month_year);
		return month_year;
	}


	public void chooseReturnDate(String returnDate) {
		String returnDay = splitDay(returnDate);
		String returnMY = splitMonthYear(returnDate);

		((JavascriptExecutor) driver).executeScript("scroll(0,150)");
		Actions actions = new Actions(driver);

		//searching flight : choosing return date

		WebElement returndate = driver.findElement(Returnbox);
		actions.moveToElement(returndate).click().perform();

		while (true) {
			WebElement returnTitle = driver.findElement(By.xpath("(//*[@class='odf-calendar-title'])[2]"));
			String s = returnTitle.getText();
			System.out.println("Return title is = "+s);
			if (s.equals(returnMY)) {
				break;
			}
			else {
				WebElement arrowBtn= driver.findElement(By.xpath("(//button[@type='button'])[4]"));
				arrowBtn.click();
			}
		}

		List<WebElement> ele = driver.findElements(By.xpath("(//div[@class='odf-col odf-col-top'])[3]/div/child::div[@class='odf-calendar-month']/div[@class='odf-calendar-row']/div[@class='odf-calendar-day']"));
		for (WebElement returnDayElement : ele) {
			String theReturnDay = returnDayElement.getText();
			System.out.println("The  return day is " + theReturnDay);
			if (theReturnDay.contains(returnDay)) {
				Actions act = new Actions(driver);
				act.moveToElement(returnDayElement).click().build().perform();
				break;
			}
		}
		driver.findElement(By.xpath("//div[@class='odf-row-float odf-row-nogutter']")).click();
	}

	public void chooseStartDate(String startDate) {
		String startDay = splitDay(startDate);
		String startMY = splitMonthYear(startDate);

		Actions actions = new Actions(driver);
		//searching flight : choosing start date
		WebElement start = driver.findElement(By.xpath("//input[contains(@placeholder,'Departure')]"));
		actions.moveToElement(start).click().build().perform();

		while (true) {
			WebElement title = driver.findElement(By.xpath("(//*[@class='odf-calendar-title'])[1]"));
			String t = title.getText();
			System.out.println("title is = "+t);
			if (t.equals(startMY)) {
				break;
			}
			else {
				WebElement arrowBtn= driver.findElement(By.xpath("(//button[@type='button'])[4]"));
				arrowBtn.click();
			}
		}

		List<WebElement> el = driver.findElements(By.xpath("//div[@class='odf-calendar-month']/div[@class='odf-calendar-row']/div[@class='odf-calendar-day']"));
		for (WebElement dayElement : el) {
			String theDay = dayElement.getText();
			System.out.println("The day is " + theDay);
			if (theDay.contains(startDay)) {
				Actions act = new Actions(driver);
				act.moveToElement(dayElement).click().build().perform();
				break;
			}
		}
		driver.findElement(By.xpath("//div[@class='odf-row-float odf-row-nogutter']")).click();
	}


	public void acceptCondition() {
		wt = new WebDriverWait(driver,20);
		WebElement conditions = wt.until(ExpectedConditions.elementToBeClickable((AgreeClosebtn)));
		conditions.click();
	}


	public FlightDetailsPage clickSearchFlight() {
		try {
		driver.findElement(SearchFlight).click();
		}catch (Exception e) {
		driver.findElement(searchFlight1).click();
		} 
		return new FlightDetailsPage(driver);

	}

	public boolean checkSearchResults() {
		WebElement Results = driver.findElement(resultsShown);
		System.out.println( Results.isDisplayed());
		return Results.isDisplayed();
	}

	public void chooseWay(String way) {
		String userWayChoice = way;
		Actions act = new Actions(driver);
		switch(userWayChoice) {
		case "One way":
			WebElement oneway = driver.findElement(one_way);
			act.moveToElement(oneway).click().build().perform();
			break;
		case "Multi-city":
			WebElement multi = driver.findElement(multiCity);
			act.moveToElement(multi).click().build().perform();
			break;
		}
	}

	public  void chooseClass(String cl) {
		String userClass = cl;
		driver.findElement(classLink).click();
		Actions act = new Actions(driver);
		try {
		List<WebElement> c = driver.findElements(By.xpath("//div[@class=\"odf-col odf-stroke-primary-right odf-space-outer-right-m\"]/following-sibling::div/div/div[2]/div/ul/li"));
		for (WebElement cla : c) {
			String usercl = cla.getText();
			if (usercl.equals(cl)) {
				act.moveToElement(cla).click().build().perform();
			}
		}
		}catch (Exception e) {
		
		}
	}


}
