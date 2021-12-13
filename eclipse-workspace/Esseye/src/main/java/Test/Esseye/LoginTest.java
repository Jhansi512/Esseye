package Test.Esseye;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	public static  void main(String args[]) throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\40036\\eclipse-workspace\\Esseye\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://siam3.eseye.com/");
        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("tester");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Passw0rd12");
        WebElement signin=driver.findElement(By.id("login"));
        signin.click();
        driver.quit();
        
	}
	
	public static void readDataFromExcel() throws IOException {
		File file =    new File("");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = book.getSheetAt(1);
		String data = sheet.getRow(1).getCell(1).getStringCellValue();
	}
}
