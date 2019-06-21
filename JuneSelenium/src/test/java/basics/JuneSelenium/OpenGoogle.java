package basics.JuneSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OpenGoogle {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("https://www.google.com/"); //open the website
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver(); //opening the browser
		driver.manage().window().maximize(); //maximize the browser
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000); //wait
		driver.close(); //close the browser
	}

}
