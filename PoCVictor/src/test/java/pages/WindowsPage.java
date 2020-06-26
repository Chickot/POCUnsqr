package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WindowsPage extends BasicPage {
	//WebDriver driver;
	
    By menuWindows = By.id("c-shellmenu_50");
    By menuItems = By.xpath("//*[@id=\"c-shellmenu_51\"] | //*[@id=\"c-shellmenu_52\"] | //*[@id=\"c-shellmenu_53\"] | //*[@id=\"c-shellmenu_54\"] | //*[@id=\"c-shellmenu_55\"] | //*[@id=\"c-shellmenu_56\"]  | //*[@id=\"c-shellmenu_57\"]  | //*[@id=\"c-shellmenu_58\"] | //*[@id=\"c-shellmenu_59\"] | //*[@id=\"c-shellmenu_60\"]");
    By menuContainer = By.xpath("//*[@id=\"uhf-g-nav\"]/ul/li[2]/div/ul");
    By seachButton = By.id("search");
    By searchBox = By.id("cli_shellHeaderSearchInput");
    
    public WindowsPage(WebDriver driver) {
		this.driver = driver;
	}
    
    public void clickMenuWindows() {
    	driver.findElement(menuWindows).click();
    }
    
    public void clickSearchButton() {
    	driver.findElement(seachButton).click();
    }
    
    public void searchString(String s) {
    	driver.findElement(searchBox).sendKeys(s);
    	driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }
    
    public List<WebElement> getMenuElements() {
    	//WebElement container = driver.findElement(menuContainer);
    	System.out.println(driver.findElements(menuItems).size());
    	return driver.findElements(menuItems);
    }
}
