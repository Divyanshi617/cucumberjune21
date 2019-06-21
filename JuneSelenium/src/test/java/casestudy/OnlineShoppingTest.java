package casestudy;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.testng.annotations.BeforeTest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {

	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriverWait wait;


	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp");

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") 
				+ "/extent-reports/" + new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy")
				.format(new Date()) + ".html");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
		extent.setSystemInfo("Environment", "Automation Testing Selenium");
		extent.setSystemInfo("User Name", "Div Agar");

		htmlReporter.config().setDocumentTitle("Title of the report comes here");
		htmlReporter.config().setReportName("Name of the report name comes here");
		htmlReporter.config().setTheme(Theme.STANDARD);		
	}

	@Test(priority=1)
	public void testregistration() {
		
		 logger=extent.createTest("passTest");
		 
		driver.get("http://10.232.237.143:443/TestMeApp");
		String homeTitle=driver.getTitle();
		System.out.println("home page title is"+homeTitle);

		driver.findElement(By.xpath("//a[contains(.,'SignUp')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'userName')]")).sendKeys("Himawari");
		driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).click();

		driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys("Himawari");
		driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("Nuhara");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("password123");
		driver.findElement(By.xpath("//input[@type='password'][contains(@id,'confirmation')]")).sendKeys("password123");
		driver.findElement(By.xpath("//span[contains(.,'Female')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'emailAddress')]")).sendKeys("aa123@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,'mobileNumber')]")).sendKeys("9876543212");
		driver.findElement(By.xpath("//input[contains(@name,'dob')]")).sendKeys("07/01/1996");
		driver.findElement(By.xpath("//textarea[@name='address'][contains(.,'Address')]")).sendKeys("uhyjfhgrtfthyjtyht");
		Select secques=new Select(driver.findElement(By.id("securityQuestion")));
		secques.selectByValue("411010");
		driver.findElement(By.xpath("//input[contains(@name,'answer')]")).sendKeys("kanpur");

		String txt = driver.findElement(By.xpath("//span[@class='label label-default'][contains(.,'Available')]")).getText();
		Assert.assertTrue(txt.contains("Available"));

		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

		String txt1 = driver.findElement(By.xpath("//div[@class='row-form-group'][contains(.,'User Registered Succesfully!!! Please login')]")).getText();
		Assert.assertTrue(txt1.contains("User Registered Succesfully!!! Please login"));
		
		  logger.log(Status.PASS, MarkupHelper.createLabel("test case passed is Pass test", ExtentColor.GREEN));

	}
	
	@Test(priority = 2)
	public void testlogin() {
		
		logger=extent.createTest("passTest");
		
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.findElement(By.xpath("//a[contains(.,'SignIn')]")).click();
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("Himawari");
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("password123");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

		String txt2 = driver.findElement(By.xpath("//ul[@class='nav navbar-nav'][contains(.,'Hi, divyanshiAg     \n" + 
				"								\n" + 
				"								\n" + 
				"									 SignOut')]")).getText();

		Assert.assertTrue(txt2.contains("Hi, divyanshiAg"));
		
		  logger.log(Status.PASS, MarkupHelper.createLabel("test case passed is Pass test", ExtentColor.GREEN));




	}

	@Test(priority=3)
	public void testcart() throws InterruptedException {
		
		logger=extent.createTest("passTest");

		WebElement allcategories=driver.findElement(By.xpath("//span[contains(.,'All\n" + 
				"										Categories')]"));//categories
		Actions act=new Actions(driver);
		act.moveToElement(allcategories).click().pause(1000).perform();//hover

		WebElement homeappliances =driver.findElement(By.xpath("//span[contains(.,'Home Appliances')]"));//homeappliances hover
		act.moveToElement(homeappliances).click().pause(1000).perform();
		driver.findElement(By.xpath("//span[@onclick='getProducts(11292,112106)'][contains(.,'Floor')]")).click();//floor

		driver.findElement(By.xpath("//a[contains(@class,'btn btn-success btn-product')]")).click();//add to cart

		driver.findElement(By.xpath("//a[contains(@style,'color:green')]")).click();//cart 1

		String txt4=driver.findElement(By.xpath("//h4[@class='nomargin'][contains(.,'Carpet')]")).getText();
		Assert.assertTrue(txt4.contains("Carpet"));		

		driver.findElement(By.xpath("//a[contains(@class,'btn btn-success btn-block')]")).click();
		driver.findElement(By.xpath("//textarea[@name='ShippingAdd']")).sendKeys("magarpatta");//shipping address
		driver.findElement(By.xpath("//input[contains(@value,'Proceed to Pay')]")).click();//proceed to pay
		
	     logger.log(Status.PASS, MarkupHelper.createLabel("test case passed is Pass test", ExtentColor.GREEN));

	}
	@Test(priority=4)
	public void testpayment() throws InterruptedException {
		logger=extent.createTest("passTest");


		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(.,'Andhra Bank')]")).click();//radio button
		driver.findElement(By.xpath("//a[contains(@onclick,'radioValue()')]")).click();//continue

		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("123456");//username

		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("Pass@456");//password

		driver.findElement(By.xpath("//input[contains(@value,'LOGIN')]")).click();//login

		driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");//transaction password

		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();//submit

		String text=driver.findElement(By.xpath("//p[contains(.,'Your order has been confirmed')]")).getText();

		Assert.assertTrue(text.contains("Your order has been confirmed"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("test case passed is Pass test", ExtentColor.GREEN));
	}

	@Test
	public void passTest() {
		logger = extent.createTest("passTest");
		Assert.assertTrue(true);
		logger.log(Status.PASS, MarkupHelper.createLabel("test case passed is Pass test", ExtentColor.GREEN));

	}

		@Test
		public void failTest() {
			logger= extent.createTest("failTest");
			Assert.assertTrue(false);
		}
	
		@Test
		public void skipTest() {
			logger= extent.createTest("skipTest");
			throw new SkipException("Skipping - This is not ready for Testing");
		}


	@AfterTest
	public void afterTest() {
		//driver.close();
		extent.flush();
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}else if (result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
	}

}
