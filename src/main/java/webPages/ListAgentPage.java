package webPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ListAgentPage extends Base {
	
	
	@FindBy(xpath="//a[@class='listing-results-price text-price']")
	 List <WebElement> AgentsListProperties;
	  public int k;
	 public List<String> AgLists;
	
	
	 public ListAgentPage() {
		
		  PageFactory.initElements(driver,this);
		 
		  System.out.println("We are in Corresponding agent's page :Page 4");
//		 
		  k=AgentsListProperties.size();
		  System.out.println("The number of Agents Listed Properties are : " + k);
		  AgLists = new ArrayList<String>();
//		  f=10;
	  }

	  public String validateAgentTitlePage() {
		  return driver.getTitle();
		  	  }
	  
	  public List<String> AgentsListedProperties(){
		
		  for (int m=0;m<k;m++) {
				 //System.out.println(linklist.get(j).getText());  
				 AgLists.add(m,AgentsListProperties.get(m).getText() );}
		  
		  return AgLists;
	  }
	  
  public boolean validatePropertyOnAgentsPage(String fifthPrice) {
  boolean b= AgLists.contains(fifthPrice);
		  return b;
	 }
	  
	  
}



