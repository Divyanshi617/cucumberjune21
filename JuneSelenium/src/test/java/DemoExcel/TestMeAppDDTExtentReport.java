package DemoExcel;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.util.Date;

public class TestMeAppDDTExtentReport {
	WebDriver driver;
	WebDriverWait wait;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	
  @Test(dataProvider = "credentials")
  public void testmeapplogin(String username, String password) {
	  
	  logger=extent.createTest("passTest");
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignIn")));
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.name("userName")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("Login")).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
	  driver.findElement(By.linkText("SignOut")).click();
	  
	  logger.log(Status.PASS, MarkupHelper.createLabel("test case passed is Pass test", ExtentColor.GREEN));
	  
  }

  @DataProvider(name="credentials")
  public Object[][] getData() throws IOException {
    return MyExcelReader.ReadData(); 
     
    
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  wait=new WebDriverWait(driver,30);
	  
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") 
				+ "/extent-reports/" + new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy")
				.format(new Date()) + ".html");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
		extent.setSystemInfo("Environment", "Automation Testing Selenium");
		extent.setSystemInfo("User Name", "Pratiksha Daptare");

		htmlReporter.config().setDocumentTitle("Title of the report comes here");
		htmlReporter.config().setReportName("Name of the report name comes here");
		htmlReporter.config().setTheme(Theme.STANDARD);		
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
	
  }

}
