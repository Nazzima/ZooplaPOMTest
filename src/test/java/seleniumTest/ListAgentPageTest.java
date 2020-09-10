package seleniumTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import base.Base;
import webPages.DesiredListPage;
import webPages.HomePage;
import webPages.ListAgentPage;
import webPages.SearchListPage;


import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

public class ListAgentPageTest extends Base {
	HomePage homePg;
	SearchListPage searchListPg;
	DesiredListPage desListPg;
	ListAgentPage listAgentPg;
	public String fifthList;
	
	public ListAgentPageTest() {
	super();	
	}
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		homePg=new HomePage();
		searchListPg=homePg.SearchLocationInput(prop.getProperty("searchlocation"));
		fifthList=searchListPg.getFifthList();
		desListPg=searchListPg.selectProperty();
		listAgentPg=desListPg.ClickAgentName();
	}
	
	
	@Test(priority=1)
	public void agentPageTest() {
		Assert.assertEquals(listAgentPg.validateAgentTitlePage(),desListPg.title0fAgentPage);
		
	}
	@Test(priority=2)
	public void AgentListedPropertiesTest() {
		System.out.println(listAgentPg.AgentsListedProperties());
	}
	@Test(priority=3)
	public void fifthPropInAgentsListTest() {
		boolean b=listAgentPg.validatePropertyOnAgentsPage(fifthList);
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void teardown() throws IOException {
		//driver.close();
//		if(driver!=null){
//			driver.quit();
		 Runtime.getRuntime().exec("taskkill/ f /im chromrderiver.exe");
		// driver.quit();
	}
	
}
