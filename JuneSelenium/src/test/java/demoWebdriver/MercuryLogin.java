package demoWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MercuryLogin {
	WebDriver  driver;
	@Test
	public void f() throws InterruptedException {
		driver.findElement(By.name("userName")).sendKeys("invalidUN");
		driver.findElement(By.name("password")).sendKeys("invalidPW");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
