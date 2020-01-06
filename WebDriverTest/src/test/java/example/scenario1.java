package example;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class scenario1 {
	public static WebDriver driver;
	HashMap<String,String> values = Amazon.getList();
	
	
  @BeforeTest
  public void beforeTest() {
//	  ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=/Users/xuhangliu/Library/Application Support/Google/");
//		System.setProperty("webdriver.chrome.driver", "chromedriver");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.amazon.com/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");
				
	  }
	
  @Test(priority = 1,description = "Register a new Amazon account")
  public void reg_user_positive() {
	  System.out.print(values);
	  // Clicking account sign-in
      //WebElement signIn = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]"));
      //signIn.click();
      //WebDriverWait wait = new WebDriverWait(driver,30);
      //this.takeSnapShot(driver,"signin.png");
      //CreateAccount Submit Button
     // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("createAccountSubmit")));
      //WebElement header = driver.findElement(By.xpath("//*[@id=\\\"nav-flyout-ya-newCust\\\"]/a"));
      //header.click();
      
      //WebElement signIn = driver.findElement(By.xpath("*[@id=\"nav-signin-tooltip\"]/div/a"));
      //signIn.click();
      	

      driver.findElement(By.xpath("//*[@id='ap_customer_name']")).sendKeys(values.get("name"));
      driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(values.get("email"));
      driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(values.get("password"));
      driver.findElement(By.xpath("//input[@id='ap_password_check']")).sendKeys(values.get("password_check"));
      
      WebElement createAccountSubmit = driver.findElement(By.id("continue"));
      createAccountSubmit.click();
      Amazon.takeSnapShot(driver,"/Users/xl/Documents/Projects/WebDriverTest/src/test/java/example/Scenario1/Create.png");

  }
  
  @Test(priority = 2, description = "Register a new Amazon account")
  public void reg_user_negative() {
	  System.out.print(values);
	  driver.get("https://www.amazon.com/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");
	  // Clicking account sign-in
      //WebElement signIn = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]"));
      //signIn.click();
      //WebDriverWait wait = new WebDriverWait(driver,30);
      //this.takeSnapShot(driver,"signin.png");
      //CreateAccount Submit Button
      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("createAccountSubmit")));
      //WebElement header = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a"));
      //header.click();

      driver.findElement(By.xpath("//*[@id='ap_customer_name']")).sendKeys(values.get("name"));
      driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(values.get("invalid_email"));
      driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(values.get("password"));
      driver.findElement(By.xpath("//input[@id='ap_password_check']")).sendKeys(values.get("password_check"));
      
      WebElement createAccountSubmit = driver.findElement(By.id("continue"));
      createAccountSubmit.click();
      Amazon.takeSnapShot(driver,"/Users/xl/Documents/Projects/WebDriverTest/src/test/java/example/Scenario1/FailCreate.png");
//      try {
//          Thread.sleep(100);
//      } catch(InterruptedException e) {
//          System.out.println("got interrupted!");
//      }
      
      String expect = values.get("email");
      String actual= values.get("invalid_email");
      AssertJUnit.assertEquals(actual, expect);

  }
  
  
  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
