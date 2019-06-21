package DemoActions;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class HandBag {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"myInput\"]"));
	  Actions act=new Actions(driver);
	  
	 act.keyDown(searchbox, Keys.SHIFT).perform();
	 act.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").perform();
	 
	 Thread.sleep(3000);
	 act.moveToElement(driver.findElement(By.xpath("(//div[contains(.,'Hand bag')])[4]"))).click();
	 driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	 Thread.sleep(3000);
	 
	 String text=driver.findElement(By.xpath("//h4[contains(.,'Hand bag')]")).getText();
	 Assert.assertTrue(text.contains("Hand"));
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
