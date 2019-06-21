package demoWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DemoAlert {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://demo.automationtesting.in/Alerts.html");
 
	  driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]"));
	  driver.findElement(By.xpath("//button[@class='btn btn-info']"));
	  
	  
//	  
//	  driver.findElement(By.cssSelector(".analystic")).click();
//	  driver.findElement(By.cssSelector(".btn btn-info")).click();
	  
	  Alert altbox=driver.switchTo().alert();
	  String altmsg=altbox.getText();
	  System.out.println("alert msg is"+altmsg);
	  
	  altbox.sendKeys("divyanshi");
	  altbox.accept();
	  altbox.dismiss();
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
