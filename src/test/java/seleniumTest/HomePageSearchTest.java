package seleniumTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import base.Base;
import utilities.Util;
import webPages.DesiredListPage;
import webPages.HomePage;
import webPages.ListAgentPage;
import webPages.SearchListPage;



public class HomePageSearchTest extends Base {
	HomePage homePg;
	SearchListPage SearchListPg;
	public String sheetName="HomePageData";
	
	public HomePageSearchTest() {
		
	super();
		}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		homePg=new HomePage();
	}
		
	 @DataProvider
	   public Object[][] getHomePgData(){
		   Object[][] data=Util.getTestData(sheetName);
		   return data;
	   }
	   @Test(dataProvider="getHomePgData")
	   public void searchDataInputTest(String CityName,String MinPrice, String MaxPrice, String PropertyType,String BedRooms) {
		   
		  SearchListPg=  homePg.SearchValuesInput(CityName, MinPrice, MaxPrice, PropertyType, BedRooms);
		  System.out.println("The input city is "+ CityName);
		  System.out.println(driver.getTitle());
		  String title=driver.getTitle();
		  boolean flag=title.toLowerCase().contains(CityName.toLowerCase());
		  Assert.assertTrue(flag);
		  driver.close(); 
	   }	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
}

