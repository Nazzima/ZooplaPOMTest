package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import utilities.Util;
//import utilities.WebEventListener;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	//public String testListPrice;
public Base() {
	
	try {
		prop=new Properties();
		FileInputStream fos=new FileInputStream("C:\\MyWorkCenter\\codeExercises\\eclipseWorkspace\\ZooplaSiteTest\\src\\main\\java\\config\\config.properties");
	    prop.load(fos);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//testListPrice=null;
}
public static void initialization() {
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		// if you dont give the path, illegalStateException error will come
		System.setProperty("webdriver.chrome.driver","C:\\MyWorkCenter\\downloads\\chromedriver.exe");
		driver =new ChromeDriver();
		}
	else if(browserName.startsWith("fire")) {
 
		System.setProperty("webdriver.gecko.driver","C:\\MyWorkCenter\\downloads\\Selenium\\geckodriver.exe"); // if you dont give the path, illegalStateException error will come
		FirefoxDriver driver = new FirefoxDriver();
	}
	
//	e_driver=new EventFiringWebDriver(driver);
//	eventListener=new WebEventListener();
//	e_driver.register(eventListener);
//	driver=e_driver; 
//	
	driver.get(prop.getProperty("url"));
	//driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Util.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	
	
}
}
