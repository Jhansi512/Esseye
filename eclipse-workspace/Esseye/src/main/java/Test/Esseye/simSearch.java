package Test.Esseye;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class simSearch {

	public static  void main(String args[]) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\40036\\eclipse-workspace\\Esseye\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://siam3.eseye.com/");
        driver.manage().window().maximize();
        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("tester");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Passw0rd12");
        WebElement signin=driver.findElement(By.id("login"));
        signin.click();
        File file =    new File("C:\\Users\\40036\\eclipse-workspace\\Esseye\\data\\esseye.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = book.getSheet("search");
		String data = sheet.getRow(1).getCell(1).getStringCellValue();
		String ICCID1 = data.substring(0, 19);
		String data2 = sheet.getRow(2).getCell(1).getStringCellValue();
		String ICCID2 = data2.substring(0, 19);
        WebElement textbxICCID=driver.findElement(By.id("matchString"));
        textbxICCID.sendKeys(ICCID1);
        WebElement search=driver.findElement(By.name("btn"));
        search.click();
        WebElement logo=driver.findElement(By.id("logo"));
        logo.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("matchString")));
        WebElement textbxICCID2=driver.findElement(By.id("matchString"));
        WebElement search2=driver.findElement(By.name("btn"));
        textbxICCID2.sendKeys(ICCID2);
        search2.click();
        driver.quit();
	}
        
}

