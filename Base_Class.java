package com.Final_Project;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

	public static WebDriver driver; // null driver	
	
	public static String value;

	public static WebDriver getBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//driver//chromedriver_93.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;	
	}
	
	public static void close() {
		driver.close();
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static void navigateto(String url) {
		driver.navigate().to(url);
	}
	
	public static void navigateForward() {
		driver.navigate().forward();	
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	
	}
	//Send keys
	
	public static void inputvalues(WebElement element,String value) {
			element.sendKeys(value);
	}
	
		//click
	public static void clickOnElement(WebElement element) {
			element.click();		
	}
	
	public static void getTitle(String title) {
		driver.getTitle();
	}
	
	public static void getcurrenturl() {
		driver.getCurrentUrl();
	}
	public static void geturl(String url) {
		driver.get(url);
	}
	public static void getsize(WebElement element) {
		element.getSize();
	}
	public static void gettext(WebElement element) {
		String text = element.getText();
	System.out.println(text);
		
	}
	public static void getattribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);

	}

	//Drop down
	public static void select(WebElement element , String type, String value) {
		if (type.equalsIgnoreCase("value")) {
			Select s = new Select(element);
			s.selectByValue(value);
			
		}
		else if (type.equalsIgnoreCase("index")) {
			Select s = new Select(element);
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
			
		} 
		else if (type.equalsIgnoreCase("visible text")) {
			Select s = new Select(element);
			s.selectByVisibleText(value);
			
		}
		else {
			System.out.println("Invalid type");
			
		}
		
	}
	//Drop down deSelectBy
	public static void deselectby(WebElement element , String type, int index , String values) {
		if (type.equalsIgnoreCase("value")) {
			Select s = new Select(element);
			s.deselectByValue(values);
			
		}
		else if (type.equalsIgnoreCase("index")) {
			Select s = new Select(element);
			s.deselectByIndex(index);
			
		} 
		else if (type.equalsIgnoreCase("visible text")) {
			Select s = new Select(element);
			s.deselectByVisibleText(values);
			
		}
				
	}
	//deselectAll
	public static void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();

	}
	//Alert
	public static void simpleAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();		
	}
	public static void alertcancel() {
		Alert a = driver.switchTo().alert();
		a.dismiss();

	}
	//Mouse actions
	public static void moveto(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	public static void rightclick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();

	}
	public static void drag(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();

	}
	public void doubleclick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	
	}
	
	
	public static void mouseActions(WebElement element, String type) {
		Actions a = new Actions(driver);
		
		if (type.equalsIgnoreCase("contextclick")) {
			a.contextClick(element).perform();
		} else if (type.equalsIgnoreCase("doubleclick")) {
			a.doubleClick(element).perform();
		} else if (type.equalsIgnoreCase("moveToElement")) {
			a.moveToElement(element).perform();
		}
		
		
	}
	
	//Frames
	public static void frameindex(int index) {
	driver.switchTo().frame(index);
	
	}
	public static void framestring(String id) {
		driver.switchTo().frame(id);

	}
	public static void frameElement(WebElement element) {
		driver.switchTo().frame(element);

	}
	public static void parentframe() {
		driver.switchTo().parentFrame();

	}
	//keyBoard Actions
	public static void keyup() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);	

	}
	public static void keydown() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);	

	}
	public static void keyenter() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	

	}
	//is multiple
	public static boolean ismultiple(String value) {
		WebElement multiple = driver.findElement(By.xpath(value));
		Select s = new Select(multiple);
		return s.isMultiple();
	}
	//is displayed
	public static boolean isdisplayed(String value) {
		WebElement d = driver.findElement(By.xpath(value));
		return d.isDisplayed();
		
	}
	public static boolean isenable(String value) {
		WebElement e = driver.findElement(By.xpath(value));
		return e.isEnabled();
	}
	public static boolean isselected(String value) {
		WebElement s = driver.findElement(By.xpath(value));
		return s.isSelected();
	}
	//get options
	public static void getoptions(WebElement element) {
		Select s = new Select(element);
		java.util.List<WebElement>options = s.getOptions();
		for (WebElement get : options) {
			System.out.println(get.getText());
			
		}
	}
	
	//wait
	public static void waitImplicit(long value) {
		driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);

	}
	//TakeScreenShot
	public static void screenshot(String filename) throws Throwable {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(filename);
        FileUtils.copyFile(source, des);
		
	}
	
	public static void dropDown(String type, WebElement element, String value) {
		
		Select s = new Select(element);
		
		if (type.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (type.equalsIgnoreCase("visible text")) {
			s.selectByVisibleText(value);
		} else if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}
	}
	
	public static void sleep(long value) throws Throwable {
		
		Thread.sleep(value);
	}
	
		
	public static String particular_Data_from_Excel(String path, int row_Index, int cell_Index) throws Throwable {
		
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet sheetAt = w.getSheetAt(0);
		Row row = sheetAt.getRow(row_Index);
		Cell cell = row.getCell(cell_Index);
		CellType type = cell.getCellType();
		
		if (type.equals(CellType.STRING)) {
			
			value = cell.getStringCellValue();
		}
		else if (type.equals(CellType.NUMERIC)) {
			
			double numericCellValue = cell.getNumericCellValue();
			value = Double.toString(numericCellValue);
		}
		return value;
		
	}
	
	public static void clear_data(WebElement element) {
		element.clear();
		
	}
	
	
	
}
	
	