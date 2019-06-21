package demoWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoNavigation {
	WebDriver driver;
	@Test
	public void f() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.get("https://www.seleniumhq.org/");
		Thread.sleep(3000);

		driver.navigate().back();//clicks on browser back button
		
		//verify title and print
		String title=driver.getTitle();
		Assert.assertEquals(title,"Google");
		
		System.out.println("current url is"+driver.getCurrentUrl());

		driver.navigate().forward();//clicks on browser forward
		
		//verify title and print
		String secondtitle=driver.getTitle();
		Assert.assertEquals(secondtitle,"Selenium - Web Browser Automation");
		
		System.out.println("second url is"+driver.getCurrentUrl());


		driver.navigate().refresh();//clicks on refresh button
		System.out.println("page refreshed");
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
	}

}
