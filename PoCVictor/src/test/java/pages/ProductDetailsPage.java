package pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasicPage{
	By displayedPrice = By.xpath("//*[@id=\"ProductPrice_productPrice_PriceContainer\"]/span");
	By addToCartButton = By.id("buttonPanel_AddToCartButton");
	
	double price;
	
	
	public ProductDetailsPage(WebDriver driver, double price) {
		this.driver = driver;
		this.price = price;
	}
	
	public boolean compareDisplayedPrice() {
		Locale locale = Locale.US;
		try {
			double p = NumberFormat.getCurrencyInstance(locale).parse(driver.findElement(displayedPrice).getText()).doubleValue();
			if(p == price) return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void clickAddToCartButton() {
		driver.findElement(addToCartButton).click();
	}
}
