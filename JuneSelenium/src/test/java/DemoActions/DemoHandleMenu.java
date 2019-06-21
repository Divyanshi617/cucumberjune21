package DemoActions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DemoHandleMenu {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  WebElement aboutus=driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[3]/a/span"));
	  WebElement ouroffices=driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[3]/ul/li/a/span"));
	 WebElement chennai= driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[3]/ul/li/ul/li[1]/a/span"));
	 
	 Actions act=new Actions(driver);
	 act.moveToElement(aboutus).click().pause(4000).perform();
	 act.moveToElement(ouroffices).click().pause(4000).perform();
	 act.moveToElement(chennai).click().perform();
	 
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
  }

}
