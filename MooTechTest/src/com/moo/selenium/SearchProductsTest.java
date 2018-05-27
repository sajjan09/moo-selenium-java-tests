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
public class SearchProductsTest {

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
		System.out.println(" In tearDown() ");
		driver.quit();
	}
	
	/**
	 * Acceptance Criteria 1. When a customer searches for a valid product on the website, 
	 * they should see a view of products matching that search term - example: business cards
	 */
	@Test
	public void shouldSearchValidProducts() {
		WebElement searchElement = driver.findElement(By.id("query"));
		searchElement.sendKeys(new String[] { "business cards" });
		searchElement.submit();

		// wait till results appear on the page upto max N seconds
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement el = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".ais-hits--item")));

		// verify results
		WebElement businessCardsResult = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[3]/div/div[1]/div/div[1]/a"));
		Assert.assertTrue("Business cards text", businessCardsResult.getText().contains("Business Cards"));
		System.out.println(businessCardsResult.getText());
	}

	/**
	 * Acceptance Criteria 2. When a customer searches for an invalid product on the website, 
	 * they should receive a message telling them - example: sdjfnjsdfj
	 */
	@Test
	public void shouldSearchInvalidProduct() {
		WebElement searchElement = driver.findElement(By.id("query"));
		searchElement.sendKeys(new String[] { "sdjfnjsdfj" });
		searchElement.submit();
		// wait till results appear on the page upto max N seconds
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ais-body")));

		System.out.println("Results summary header : "+  driver.findElement(By.cssSelector(".ais-body")).getText());
		
		// verify results
		WebElement resultsSection = driver.findElement(By.cssSelector(".u-color-loud"));
		System.out.println("resultsSection.getText() : " +  resultsSection.getText());
		Boolean isTextPresent = resultsSection.getText().contains("No pages found");
		Assert.assertTrue("Expected text message didnt match",isTextPresent);
		System.out.println("isTextPresent: " + isTextPresent);
	}
}
