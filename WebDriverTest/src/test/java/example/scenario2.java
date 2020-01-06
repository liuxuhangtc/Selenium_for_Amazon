package example;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class scenario2 {
	public static WebDriver driver;

	//HashMap<String,String> values = Test_Data.getList();
	 /*Row l1row1 = sheet1.getRow(1);
	Cell r1login1 = l1row1.getCell(0);
	String r1l1 = r1login1.toString();
	
	 Row l2row2 = sheet1.getRow(2);
		Cell r2login1 = l2row2.getCell(1);
		String r2l2 = r2login1.toString();*/
	
	@BeforeTest
	  public void beforeTest() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("incognito");
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		cap.setCapability(ChromeOptions.CAPABILITY, options);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=/Users/xuhangliu/Library/Application Support/Google/");
//		System.setProperty("webdriver.chrome.driver", "chromedriver");
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=");
					
		  }
	
//	@Test(priority=1,description = "Sign in to Amazon account")
//	public void sign_in_negative() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException  {
//		
//		String file_path = "/Users/xuhangliu/Documents/Projects/WebDriverTest/test.xls";
//
//		// Creating a Workbook from an Excel file (.xls or .xlsx)
//		Workbook workbook = WorkbookFactory.create(new File(file_path));
//		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
//		// Create a DataFormatter to format and get each cell's value as String
//		DataFormatter dataFormatter = new DataFormatter();
//		String username = "";
//		String password1 = "";
//		String password2 = "";
//			Sheet sheet = sheetIterator.next();
//			Row row = sheet.getRow(0);
//			Cell cell1 = row.getCell(2);
//			username = dataFormatter.formatCellValue(cell1);
//			
//			Cell cell2 = row.getCell(3);
//			password1 = dataFormatter.formatCellValue(cell2);
//			Cell cell3 = row.getCell(4);
//			password2 = dataFormatter.formatCellValue(cell3);
////		
//	   //Enter Login-id
//		driver.findElement(By.id("ap_email")).sendKeys(username);
//		
//	    driver.findElement(By.id("continue")).click();
//	    
//	    //Enter password
//	    driver.findElement(By.id("ap_password")).sendKeys(password2);
//	    driver.findElement(By.id("signInSubmit")).click();
//	    
//	    
//	    //Thread.sleep(20000);
//	    String expect = password1;
//	    String actual= password2;
//	    Assert.assertEquals(actual, expect, "The Password was wrong.");
//	    Amazon.takeSnapShot(driver,"/Users/xuhangliu/Documents/Projects/WebDriverTest/src/test/java/example/Scenario2/FailLogin.png");
//		
//	}

	@Test(priority=2,description = "Sign in to Amazon account")
	public void sign_in_positive() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		String file_path = "/Users/xl/Documents/Projects/WebDriverTest/test.xls";

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(file_path));
		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();
		String username = "";
		String password = "";
			Sheet sheet = sheetIterator.next();
			Row row = sheet.getRow(1);
			Cell cell1 = row.getCell(2);
			username = dataFormatter.formatCellValue(cell1);
			Cell cell2 = row.getCell(3);
			password = dataFormatter.formatCellValue(cell2);
		
			driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&switch_account=");	
			
	   //Enter Login-id
		driver.findElement(By.id("ap_email")).sendKeys(username);
		
	    driver.findElement(By.id("continue")).click();
	    
	    //Enter password
	    driver.findElement(By.id("ap_password")).sendKeys(password);
	    driver.findElement(By.id("signInSubmit")).click();
	    
	    //OTP handle
	    
	    //Thread.sleep(20000);
	    Amazon.takeSnapShot(driver,"/Users/xl/Documents/Projects/WebDriverTest/src/test/java/example/Scenario2/Login.png");
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}