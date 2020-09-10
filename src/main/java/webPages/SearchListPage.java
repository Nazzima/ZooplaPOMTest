package webPages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.CharMatcher;

import base.Base;
import utilities.Util;

public class SearchListPage extends Base {
	@FindBy(xpath="//a[@class='listing-results-price text-price']")
	 List <WebElement> priceList;

	public int i;
	public  List<String> l1;
	public List<Integer> pr;
	public WebElement fifthListLocation;
	public String testListPrice;
	public String title0fDeisredProperty;
	
	 public SearchListPage()  {
		 PageFactory.initElements(driver,this);
		
		   i=priceList.size();
		  l1 = new ArrayList<String>(); 
		 pr =new ArrayList<Integer>();
		 System.out.println("We are in Search List Page : Page 2");
	 }
	 
	 public String validateTitleOfSearchListsPage() {
		 return driver.getTitle();
	 }
	public String getFifthList() {
		for (int j = 0; j < i; j++) {
			// System.out.println(linklist.get(j).getText());
			l1.add(j, priceList.get(j).getText());
			String s = CharMatcher.inRange('0', '9').retainFrom(priceList.get(j).getText());
			int n;
			if (s.length() == 0) {
				pr.add(j, 0);
			} else {
				n = Integer.parseInt(s);
				pr.add(j, n);
			}

			if (j == 4) {
				fifthListLocation = priceList.get(j);
				System.out.println("The fifth list is " + priceList.get(j).getText());
			}
		}
		 testListPrice = fifthListLocation.getText();
		return testListPrice;
	 }
	
	public List<String> getAllPricesList(){
		return l1;
	}
	
	 public List<Integer> priceListDescOrder(){
	
		 System.out.println(l1);
	 Collections.sort(pr);
	  Collections.reverse(pr);
	  return pr;
	  //System.out.println(pr);
	  }
	 public DesiredListPage selectProperty() {
		
			WebDriverWait wait=new WebDriverWait(driver,25);
			wait.until(ExpectedConditions.elementToBeClickable(fifthListLocation));
	 	  fifthListLocation.click();
//		 JavascriptExecutor executor = (JavascriptExecutor)driver;
//		 	executor.executeScript("arguments[0].click();",fifthListLocation );
	 	  title0fDeisredProperty=driver.getTitle(); 
	 	 	
	 	  return new DesiredListPage();
	 }

}
