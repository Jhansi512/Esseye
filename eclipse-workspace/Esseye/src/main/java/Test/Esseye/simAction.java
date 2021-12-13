package Test.Esseye;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class simAction {

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
		WebElement textbxICCID=driver.findElement(By.id("matchString"));
        textbxICCID.sendKeys(ICCID1);
        WebElement search=driver.findElement(By.name("btn"));
        search.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        Select action = new Select(driver.findElement(By.id("selAction")));
        action.selectByVisibleText("Change Settings");
        WebElement actionButton=driver.findElement(By.name("axnbtn"));
        actionButton.click();
        driver.quit();
        
	}
        
}

