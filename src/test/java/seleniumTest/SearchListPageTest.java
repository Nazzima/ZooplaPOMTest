package seleniumTest;

//import org.testng.annotations.BeforeMethod;

//import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import base.Base;

import webPages.DesiredListPage;
import webPages.HomePage;
import webPages.ListAgentPage;
import webPages.SearchListPage;


public class SearchListPageTest extends Base {
	HomePage homePg;
	SearchListPage searchListPg;
	DesiredListPage desListPg;
	
	public SearchListPageTest() {
		super();
	}
	
	
	@BeforeClass
	public void setUp() {
		initialization();
		homePg=new HomePage();
		searchListPg=homePg.SearchLocationInput(prop.getProperty("searchlocation"));
		//System.out.println("We are getting all the list prices of properties in descending order & selecting the 5th list");
		
	}

	
	@Test(priority=1)
	public void SearchListPageTitleTest() {
		String title=searchListPg.validateTitleOfSearchListsPage();
		Assert.assertEquals(title,"Property for Sale in London - Buy Properties in London - Zoopla");
	}
	
	@Test(priority=2)
	public void FifthListTest() {
//		List<String> AllPriceListed=searchListPg.AllPricesList();
//		System.out.println(searchListPg.AllPricesList());
//		String FifthListedPrice=searchListPg.getFifthList();
		//boolean b=AllPriceListed.contains(FifthListedPrice);
		boolean b=searchListPg.getAllPricesList().contains(searchListPg.getFifthList());
		Assert.assertTrue(b);
		}
	
	@Test(priority=5)
	public void fifthListNegativeTest() {
		
		boolean b=NumberUtils.isNumber(searchListPg.testListPrice);
		System.out.println(searchListPg.testListPrice);
		Assert.assertFalse(b);
	}
	
	@Test(priority=3)
	public void ListDescOrderTest() {
		
		boolean descOrderDone= Ordering.natural().reverse().isOrdered(searchListPg.priceListDescOrder());
		Assert.assertTrue(descOrderDone);
		System.out.println(searchListPg.priceListDescOrder());
		
	}
	@Test(priority=4)
	public void ClickFifthProperty() throws InterruptedException {
		desListPg= searchListPg.selectProperty();
		
		System.out.println(driver.getTitle());
	}
	@AfterTest
	public void tearDown() {
		//driver.close();
		}
	
	
}
