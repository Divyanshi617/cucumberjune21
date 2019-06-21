package demoWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoRegister {
	WebDriver driver;
	@Test
	public void f() throws InterruptedException {
		driver.get("http://newtours.demoaut.com/");
		String homeTitle=driver.getTitle();
		System.out.println("home page title is"+homeTitle);
		Assert.assertEquals(homeTitle, "Welcome: Mercury Tours");
		driver.findElement(By.partialLinkText("REGIS")).click();
		System.out.println("register page link="+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("divyanshi");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("agarwal");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8115531301");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("divyanshi0770@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("magarpatta");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("maharashtra");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("411057");

		Select countryname=new Select(driver.findElement(By.name("country")));
		countryname.selectByIndex(4);
		Thread.sleep(3000);
		countryname.selectByValue("8");
		Thread.sleep(3000);
		countryname.selectByVisibleText("INDIA");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("divyanshi123");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("divyanshi#123");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("divyanshi#123");

		driver.findElement(By.xpath("//input[@name='register']")).click();



	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();



	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
