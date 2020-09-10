package seleniumTest;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import base.Base;
import webPages.DesiredListPage;
import webPages.HomePage;
import webPages.ListAgentPage;
import webPages.SearchListPage;

public class DesiredListPageTest extends Base {
	HomePage homePg;
	SearchListPage searchListPg;
	DesiredListPage desListPg;
	ListAgentPage listAgentPg;
	public WebElement fifthProperty;
	String fifthList;
	public DesiredListPageTest() {
		super();
		
		
	}
	@BeforeClass
	public void setUp() throws InterruptedException {
		
		initialization();
		homePg=new HomePage();
		//searchListPg=new SearchListPage();
		//desListPg=new DesiredListPage();
		//listAgentPg=new ListAgentPage();
		searchListPg=homePg.SearchLocationInput(prop.getProperty("searchlocation"));
		fifthList=searchListPg.getFifthList();
		//fifthProperty=searchListPg.fifthListLocation;
//		fifthProperty.click();
		
		System.out.println(searchListPg.fifthListLocation);
		desListPg=searchListPg.selectProperty();
						
	}
@Test(priority=1)
public void TitleOfListTest() {
	Assert.assertEquals(desListPg.validateTitleOfList(),searchListPg.title0fDeisredProperty);
}
@Test(priority=2)	
public void getAgentPageTest() throws InterruptedException  {
	//listAgentPg=new ListAgentPage();
	listAgentPg=desListPg.ClickAgentName();
	
}
@AfterSuite
public void teardown() throws IOException {
//	if(driver!=null){
	//driver.quit();
//	}
	 Runtime.getRuntime().exec("taskkill/ f /im chromrderiver.exe");
}

}
