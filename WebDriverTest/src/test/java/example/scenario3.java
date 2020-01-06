package example;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;

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


public class scenario3 {
	public static WebDriver driver;


	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=/Users/xl/Library/Application Support/Google/");
		System.setProperty("webdriver.chrome.driver", "chromedriver");
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		//Need to Add Login process
	}

	@Test(priority = 1, description = "Add first item")
	public void addFirstItem() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

		String file_path = "/Users/xl/Documents/Projects/WebDriverTest/test.xls";

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(file_path));
		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();
		String c1 = "";
			Sheet sheet = sheetIterator.next();
			Row row = sheet.getRow(1);
			Cell cell1 = row.getCell(0);
			c1 = dataFormatter.formatCellValue(cell1);
		
		Thread.sleep(8000);
		//need to read data from csv instead of ipad
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(c1);
		driver.findElement(By.className("nav-input")).click();
		driver.findElement(By.className("s-image")).click();
		driver.findElement(By.id("a-autoid-0-announce")).click();
		driver.findElement(By.id("quantity_2")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("attachSiNoCoverage-announce")).click();
		driver.findElement(By.className("a-button-input")).click();
		Amazon.takeSnapShot(driver, "/Users/xl/Documents/Projects/WebDriverTest/src/test/java/example/Scenario3/AddFirstItem.png");
	}
	
	
	
	@Test(priority = 2,description = "Add second item")
	public void addSecondItem() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		String file_path = "/Users/xl/Documents/Projects/WebDriverTest/test.xls";

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(file_path));
		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();
		String c2 = "";
			Sheet sheet = sheetIterator.next();
			Row row = sheet.getRow(1);
			Cell cell2 = row.getCell(1);
			c2 = dataFormatter.formatCellValue(cell2);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(c2);
		driver.findElement(By.className("nav-input")).click();
		driver.findElement(By.className("s-image")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		Amazon.takeSnapShot(driver, "/Users/xl/Documents/Projects/WebDriverTest/src/test/java/example/Scenario3/AddSecondItem.png");
		driver.findElement(By.id("hlb-ptc-btn-native")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}



