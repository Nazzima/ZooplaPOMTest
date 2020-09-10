package webPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import utilities.Util;

public class DesiredListPage extends Base {
	@FindBy(xpath="//*[@id=\"cookie-consent-form\"]/div/div/div/button[2]")
	WebElement CookieAcceptBtn;
	
	@FindBy(xpath="//a[contains(@class,'ui-agent__details') and @data-track-label='Agent block 1']")
	WebElement AgentName;
	
	
	public String title0fAgentPage;
	
	public  DesiredListPage() {
		 PageFactory.initElements(driver,this);
		
		 	System.out.println("We are in our selected property page : Page 3");
		 	
	}
	public String validateTitleOfList() {
				
		return driver.getTitle();
		
	}
public ListAgentPage ClickAgentName() throws InterruptedException {

    //CookieAcceptBtn.Click();
	 driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
 	driver.manage().timeouts().implicitlyWait(Util.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver,25);
	wait.until(ExpectedConditions.visibilityOf(AgentName));
	Thread.sleep(5000);
//	JavascriptExecutor executor = (JavascriptExecutor)driver;
//	executor.executeScript("arguments[0].click();", AgentName);
// 	Actions act =new Actions(driver);
// 	act.moveToElement(AgentName).doubleClick().build().perform();
	AgentName.click();
	title0fAgentPage=driver.getTitle();
	
	return new ListAgentPage();
}
}
