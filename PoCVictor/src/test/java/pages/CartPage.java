package pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasicPage{

	By displayedPrice = By.xpath("//*[@id=\"store-cart-root\"]/div/div/div/section[2]/div/div/div[2]/div/span/span[2]/strong/span");
	By dropDown = By.xpath("//select");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean compareDisplayedPrice(double price) {
		Locale locale = Locale.US;
		try {
			double p = NumberFormat.getCurrencyInstance(locale).parse(driver.findElement(displayedPrice).getText()).doubleValue();
			System.out.println("compareDisplayedPrice: " + p);
			if(p == price) return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void waitForObject() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectElement(String s) {
		Select dropDownSelect = new Select(driver.findElement(dropDown));
		dropDownSelect.selectByVisibleText(s);
	}
}
