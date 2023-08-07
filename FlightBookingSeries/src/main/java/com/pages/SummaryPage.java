package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {
	
	private WebDriver driver;
	private WebDriverWait wt;

	public SummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	//By Locators:OR
	By nuisanceBox = By.xpath("(//*[@class='odf-box-content odf-box-content-md'])[2]/button[2]");
	By smryPage = By.xpath("//span[@class='odf-flex-item  ']"); 

	public void chooseseat(String seatnum) {
		try {
			wt= new WebDriverWait(driver,20);
			WebElement Nuisance = driver.findElement(nuisanceBox);
			wt.until(ExpectedConditions.elementToBeClickable(Nuisance));
		}
		catch (Exception e) {
			String i= seatnum;

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//div[@class='od-aircraftmap-row'])[5]")));


			WebElement wintest = driver.findElement(By.xpath("//div[@class='od-aircraftmap-row']/div/child::div[@id='aircraft_map_"+i+"']/div"));
			String text = wintest.getAttribute("data-type");
			if(text.contains(text)) {
				System.out.println("Seat is a window seat");
			}
			else {
				System.out.println("Seat is an aisle seat");
			}
		}

	}


	public boolean checkUserInSummaryPage() {
		
		WebElement SummaryPage = driver.findElement(smryPage);
		System.out.println( SummaryPage.isDisplayed());
		return SummaryPage.isDisplayed();
	}


	
	
}
