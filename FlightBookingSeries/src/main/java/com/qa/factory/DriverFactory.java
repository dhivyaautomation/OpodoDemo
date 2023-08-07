package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * Initialising the thread local driver
	 * @param browser
	 * @return
	 */
	
	public WebDriver init_Driver(String browser) {
		System.out.println("The browser value is " + browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			tlDriver.set(new ChromeDriver());
		}
		else {System.out.println("please pass the correct browser value" + browser);}

		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		//		Thread.sleep(2000);
		return getDriver();
	}

	
	
	/**
	 * This is used to get the driver with Thread Local
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
