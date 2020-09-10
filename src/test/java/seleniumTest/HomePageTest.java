
/* @author nazima */
package seleniumTest;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import webPages.HomePage;
import webPages.SearchListPage;
import utilities.Util;

public class HomePageTest extends Base {
	HomePage homePg;
	SearchListPage SearchListPg;
	//public String sheetName="HomePageData";
	Logger log=Logger.getLogger(HomePageTest.class);
	public HomePageTest() {
		
	super();
		}
	
	@BeforeClass
	public void setUp() {
		
		initialization();
		
		homePg=new HomePage();
	}
	@Test(priority=1,alwaysRun=true)
	public void HomePageTitleTest() {
		log.info("We are doing Title Validation now");
		String title=homePg.ValidateHomePageTitle();
		Assert.assertEquals(title,"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
		
		
	}
   @Test(priority=2, alwaysRun=true)
   public void ZooplaLogoTest() {
	   boolean flag=homePg.ValidateZooplaLogo();
	   Assert.assertTrue(flag);
   }
  
   @Test(priority=3, alwaysRun=true)
   public void SearchLocationInputTest()  {
	   System.out.println("Entering the location name now");
	  	   SearchListPg=homePg.SearchLocationInput(prop.getProperty("searchlocation"));
	   	  System.out.println(driver.getTitle());
	   	  //Assert.assertEquals(title1,"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
	  System.out.println("HomePage Test Done");
   }
   @AfterTest
   public void tearDown() throws IOException {
	   
	  // driver.quit();
	   Runtime.getRuntime().exec("taskkill/ f /im chromrderiver.exe");
   }
   
}
