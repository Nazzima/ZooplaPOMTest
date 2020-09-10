package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HomePage extends Base {
	

	//WebElement Location_XPath=
			
	
		//driver.get("https://zoopla.co.uk");
		//driver.findElement(By.xpath("//*[@id=\"search-input-location\"]")).sendKeys("London");
		@FindBy(xpath="//*[@id=\"search-input-location\"]")
		WebElement SearchBox;
		@FindBy(xpath="//*[@id=\"cookie-consent-form\"]/div/div/div/button[2]")
		WebElement CookieAcceptBtn;
		@FindBy(xpath="//*[@id=\"search-submit\"]")
		WebElement SearchSubmitBtn;
		@FindBy(xpath="//a[@aria-label='Zoopla']")
		WebElement ZooplaLogo;
		@FindBy(xpath="//*[@id=\"forsale_price_min\"]")
		WebElement MinPrice;
		@FindBy(xpath="//*[@id=\"forsale_price_max\"]")
		WebElement MaxPrice;
		@FindBy(xpath="//*[@id=\"property_type\"]")
		WebElement PropertyType;
		@FindBy(xpath="//*[@id=\"beds_min\"]")
		WebElement BedroomsCount;
		
		public HomePage() {
			PageFactory.initElements(driver,this);
			System.out.println("Here we opening the Home page of Zoopla website : Page 1");
		}
		public String ValidateHomePageTitle() {
			return driver.getTitle();
		}
		public boolean ValidateZooplaLogo() {
			return ZooplaLogo.isDisplayed();
		}
		
		public SearchListPage SearchValuesInput(String city,String minPrice,String maxPrice,String propType,String bedroomsCount) {
			CookieAcceptBtn.click();
			SearchBox.sendKeys(city);
			MinPrice.sendKeys(minPrice);
			MaxPrice.sendKeys(maxPrice);
			PropertyType.sendKeys(propType);
			BedroomsCount.sendKeys(bedroomsCount);
			SearchSubmitBtn.click();
			
			return new SearchListPage();
			
		}
		public SearchListPage SearchLocationInput(String SearchCityName)  {
			CookieAcceptBtn.click();
			SearchBox.sendKeys(SearchCityName);
			SearchSubmitBtn.click();
			//Thread.sleep(3000);
			return new SearchListPage();
			
			
			
		}
		
	
}
