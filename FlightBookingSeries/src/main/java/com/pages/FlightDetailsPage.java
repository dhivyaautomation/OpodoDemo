package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FlightDetailsPage {
	 private WebDriver driver;
	 private WebDriverWait wt;
	 
	 By resultsShown    = By.xpath("//*[@class='css-hty8f5-Box-BaseFlex e12411730']");
	 By cheapestFareTab = By.xpath("//div[@class='css-1uynx4-BaseBox-PaddingBox e4px6vc1']/div/button[2]");
	 By chooseGeniusDeal=By.xpath("(//button[contains(text(),'Select')])[1]");
	 
	 public FlightDetailsPage(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	
	 
	 public SummaryPage chooseRate() {
		Actions act = new Actions(driver);
		WebElement cheapfareTab = driver.findElement(cheapestFareTab);
		act.moveToElement(cheapfareTab).click().build().perform();
		
		
		
		WebElement chooseCheap = driver.findElement(chooseGeniusDeal);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("scroll(0,150)");
		js.executeScript("arguments[0].click();",chooseCheap);
		return new SummaryPage(driver);
	 }
	 
		
}
