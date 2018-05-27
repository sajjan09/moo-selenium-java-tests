package com.moo.selenium;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@SuppressWarnings("deprecation")
public class ViewProductsTest {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		System.out.println("In setUp() ");
		// change the gecko driver path 
		System.setProperty("webdriver.gecko.driver","C:\\E\\Shobha\\prof\\Dev-Shobha\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.moo.com/uk/");
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	/**
	 * Acceptance Criteria 3: When customer clicks on 'Products' on the menu,
	 * they should be able to see all the products  displayed on that page. 
	 */
	@Test
	public void shouldDisplayAllProducts(){
		WebElement productsMenu = driver.findElement(By.xpath("//*[@id=\"htmlBody\"]/div[1]/div[3]/div[2]/header/div[2]/div[1]/nav/ul/li[1]/a"));
		productsMenu.click();
		Assert.assertTrue(driver.getPageSource().contains("Business Cards"));
		Assert.assertTrue(driver.getPageSource().contains("Luxe Business Cards"));
		Assert.assertTrue(driver.getPageSource().contains("Postcards"));
	}
	
	/**
	 * Acceptance Criteria 4: When customer clicks on 'Business Cards' page after the 'Products' are displayed, 
	 * detailed page of business cards should be displayed.
	 */
	@Test
	public void shouldViewBusinessCardSection(){
		WebElement productsMenu = driver.findElement(By.xpath("//*[@id=\"htmlBody\"]/div[1]/div[3]/div[2]/header/div[2]/div[1]/nav/ul/li[1]/a"));
		productsMenu.click();
		Assert.assertTrue(driver.getPageSource().contains("Business Cards"));
		
		// wait till results appear on the page upto max N seconds
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div/div/div[1]/div/a/div/div/span/span")));
		
		System.out.println("clicking business card section");

		WebElement businessCardLearnMoreLink = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[1]/div/a/div/div/span/span"));
		businessCardLearnMoreLink.click();
		System.out.println("CLICKED ON business card section");
		
		// wait till results appear on the page upto max N seconds
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		WebElement el2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".h__module")));
		
		Assert.assertTrue(driver.getPageSource().contains("Shop Business Cards by Paper"));
		Assert.assertTrue(driver.getPageSource().contains("Shop Business Cards by Size"));
		
	}
		
}
