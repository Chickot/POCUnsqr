package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MicrosoftHomepage extends BasicPage{
	//WebDriver driver;
	
    By menuMicrosoft365 = By.id("shellmenu_0");
    By menuOffice = By.id("shellmenu_1");
    By menuWindows = By.id("shellmenu_2");
    By menuSurface = By.id("shellmenu_3");
    By menuXbox = By.id("shellmenu_4");
    By menuDeals = By.id("shellmenu_5");
    By menuSupport = By.id("l1_support");
    
    public MicrosoftHomepage(WebDriver driver) {
		this.driver = driver;
	}
    
    public void clickMenuWindows() {
    	driver.findElement(menuWindows).click();
    }
    
    public boolean isMenuMicrosoft365Present() {
    	return this.driver.findElements(menuMicrosoft365).size() > 0;
    }
    
    public boolean isMenuOfficePresent() {
    	return this.driver.findElements(menuOffice).size() > 0;
    }
    
    public boolean isMenuWindowsPresent() {
    	return this.driver.findElements(menuWindows).size() > 0;
    }
    
    public boolean isMenuSurfacePresent() {
    	return this.driver.findElements(menuSurface).size() > 0;
    }
    
    public boolean isMenuXboxPresent() {
    	return this.driver.findElements(menuXbox).size() > 0;
    }
    
    public boolean isMenuDealsPresent() {
    	return this.driver.findElements(menuDeals).size() > 0;
    }
    
    public boolean isMenuSupportPresent() {
    	return this.driver.findElements(menuSupport).size() > 0;
    }
    
}
