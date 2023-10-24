package org.bas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aarth\\eclipse-workspace\\CucumberProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void launchUrl(String Url) {
		driver.get(Url);
	}

	public static void windowMaxi() {
		driver.manage().window().maximize();
	}

	public static void closeEntirebrowser() {
		driver.quit();
	}

	public static void PageTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void PageUrl() {
		String Url = driver.getCurrentUrl();
		System.out.println(Url);

	}
	
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
		
	}

	public static void ClickEle(WebElement e) {
		e.click();
	}
	
	public static void ScreenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+ image.png");
		FileUtils.copyFile(image, f);
	}
	

	public static Actions a;

	public static void movetheCursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}
	
	public static void dragDrop(WebElement dragWebElement, WebElement dropElement ) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
	}

	public static JavascriptExecutor js;
	
	public static void ScrollThePage(WebElement targetWebElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", targetWebElement);
	}


	public static void Scroll(WebElement targetWebElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", targetWebElement);
	}
	
	
	
	
	public static void createNewExcelFile(int rowNum,int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\aarth\\eclipse-workspace\\BaseClass\\Excel\\WriteData.xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet newsheet = wb.createSheet("data");
		Row newrow = newsheet.createRow(rowNum);
		Cell newcell = newrow.createCell(cellNum);
		newcell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		
	}
	
	public static void createCell(int getRow,int creCell, String value) throws IOException {
		File f = new File("C:\\\\Users\\\\aarth\\\\eclipse-workspace\\\\BaseClass\\\\Excel\\\\WriteData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet S = wb.getSheet("data");
		Row row = S.getRow(getRow);
		Cell cell = row.createCell(creCell);
		cell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		
	}
	
	
	public static void createRow(int creRow,int creCell, String value) throws IOException {
		File f = new File("C:\\\\Users\\\\aarth\\\\eclipse-workspace\\\\BaseClass\\\\Excel\\\\WriteData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet S = wb.getSheet("data");
		Row row = S.createRow(creRow);
		Cell cell = row.createCell(creCell);
		cell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		
	}

		public static void excelRead(String sheetName, int rowNum, int CellNum) throws IOException {
		File f = new File("C:\\Users\\aarth\\eclipse-workspace\\MavenData\\Excel\\ExcelData.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook wb = new XSSFWorkbook(fi);

		Sheet exsheet = wb.getSheet("sheet2");
		Row row = exsheet.getRow(rowNum);
		Cell cell = row.getCell(CellNum);

		int cellType = cell.getCellType();

		String value = " ";
		
		if (cellType == 1) {

			String stringCellValue = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sd = new SimpleDateFormat("dd-MMMM-yy");
			String val = sd.format(dateCellValue);
		} else {
            double num = cell.getNumericCellValue();
			long l = (long) num;
			String valueOf = String.valueOf(l);
		}
		
	}
	}

