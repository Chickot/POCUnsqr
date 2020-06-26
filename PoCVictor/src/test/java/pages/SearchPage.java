package pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPage extends BasicPage{

	By closeButton = By.className("c-glyph glyph-cancel");
	By priceLabels = By.xpath("//div[@class='c-price' and 1]/span[3]/span[1]");
	
	double price = 0;
	
	List<WebElement> priceList;
	////div[@class='c-price' and 1]/span[3]/span[1]
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getPriceList() {
		priceList = driver.findElements(priceLabels);
		for (int i=0; i<priceList.size();i++){
		      System.out.println("Item price: " + priceList.get(i).getText());
	    }
    }
	
	public void clickFirstPrice() {
		priceList.get(0).click();
	}
	
	public double returnFirstPrice() {
		Locale locale = Locale.US;
		try {
			price = NumberFormat.getCurrencyInstance(locale).parse(priceList.get(0).getText()).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
}
