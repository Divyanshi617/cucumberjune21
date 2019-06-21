package demoWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Demourlandsource {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		//verify title an dprint
		String title=driver.getTitle();
		Assert.assertEquals(title, "Wikipedia, the free encyclopedia");
		driver.findElement(By.linkText("History")).click();
		//verift title an dprint
		String linktitle=driver.getTitle();
		Assert.assertEquals(linktitle, "Portal:History - Wikipedia");
		String url=driver.getCurrentUrl();
		System.out.println("url is"+url);
		//System.out.println("page source is"+driver.getPageSource());

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
