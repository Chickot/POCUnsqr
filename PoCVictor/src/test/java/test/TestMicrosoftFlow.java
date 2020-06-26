package test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.MicrosoftHomepage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WindowsPage;

public class TestMicrosoftFlow implements TestInterface{
	String driverPath = "C:\\Selenium Drivers\\Chrome\\chromedriver.exe";
	WebDriver driver;
	MicrosoftHomepage objMicrosoftHomepage;
	WindowsPage objWindowsPage;
	SearchPage objSearchPage;
	ProductDetailsPage objProductDetailsPage;
	CartPage objCartPage, objCartPage2;
	List<WebElement> menuElements, priceList;
	double price;

	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.microsoft.com/en-us/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void test_Flow_1(){
		//Create homepage object
		objMicrosoftHomepage = new MicrosoftHomepage(driver);
		
		//Validate menu items are present
		Assert.assertTrue(objMicrosoftHomepage.isMenuMicrosoft365Present());
		System.out.println("Is Microsoft 365 menu present: " + objMicrosoftHomepage.isMenuMicrosoft365Present());
		Assert.assertTrue(objMicrosoftHomepage.isMenuOfficePresent());
		System.out.println("Is Office menu present: " + objMicrosoftHomepage.isMenuOfficePresent());
		Assert.assertTrue(objMicrosoftHomepage.isMenuWindowsPresent());
		System.out.println("Is Windows menu present: " + objMicrosoftHomepage.isMenuWindowsPresent());
		Assert.assertTrue(objMicrosoftHomepage.isMenuSurfacePresent());
		System.out.println("Is Surface menu present: " + objMicrosoftHomepage.isMenuSurfacePresent());
		Assert.assertTrue(objMicrosoftHomepage.isMenuXboxPresent());
		System.out.println("Is Xbox menu present: " + objMicrosoftHomepage.isMenuXboxPresent());
		Assert.assertTrue(objMicrosoftHomepage.isMenuDealsPresent());
		System.out.println("Is Deals menu present: " + objMicrosoftHomepage.isMenuDealsPresent());
		Assert.assertTrue(objMicrosoftHomepage.isMenuSupportPresent());
		System.out.println("Is Support menu present: " + objMicrosoftHomepage.isMenuSupportPresent());
		
		//Click on Windows menu 
		objMicrosoftHomepage.clickMenuWindows();
		
		//Create Windows page object
		objWindowsPage = new WindowsPage(driver);
		
		//Click on Windows 10 menu
		objWindowsPage.clickMenuWindows();
		
		//Get menu elements
		menuElements = objWindowsPage.getMenuElements();
		
		//Display menu elements -- 
		//CHECARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
		for (int i=0; i<menuElements.size();i++){
		      System.out.println("Menu item: " + menuElements.get(i).getText());
	    }
		//Click on the search button
		objWindowsPage.clickSearchButton();

		//Enter search text
		objWindowsPage.searchString("Visual Studio");
		
		//Create search page object
		objSearchPage = new SearchPage(driver);
		
		//Click close button
		objSearchPage.clickCloseButton();
		
		//Get price list
		objSearchPage.getPriceList();
		
		//Store first price
		price = objSearchPage.returnFirstPrice();
				
		//Click on first price
		objSearchPage.clickFirstPrice();
		
		//Create search page object
		objProductDetailsPage = new ProductDetailsPage(driver, price);
		
		//Click close button
		objProductDetailsPage.clickCloseButton();
		
		//ComparePrice
		Assert.assertTrue(objProductDetailsPage.compareDisplayedPrice());
		System.out.println("Do prices match?: " + objProductDetailsPage.compareDisplayedPrice());
		
		//Click add to cart button
		objProductDetailsPage.clickAddToCartButton();
		
		//Create cart page object
		objCartPage = new CartPage(driver);
		
		//Validate displayed price
		Assert.assertTrue(objCartPage.compareDisplayedPrice(price));
		System.out.println("Do prices match?: " + objCartPage.compareDisplayedPrice(price));
		
		//Select 20 in dropdown
		objCartPage.selectElement("20");
		
		//Wait
		objCartPage.waitForObject();
		
		//Create cart page object
		objCartPage2 = new CartPage(driver);
		
		//Validate price
		price = price*20;
		Assert.assertTrue(objCartPage2.compareDisplayedPrice(price));
		System.out.println("Do prices match (by 20)?: " + objCartPage2.compareDisplayedPrice(price));
	}
}
