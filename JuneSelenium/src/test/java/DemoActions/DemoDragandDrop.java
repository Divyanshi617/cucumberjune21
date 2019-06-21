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

public class DemoDragandDrop {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
	  WebElement dragelement=driver.findElement(By.id("draggable"));
	  WebElement dropelement=driver.findElement(By.id("droppable"));
	  
	  Actions act=new Actions(driver);
	  act.dragAndDrop(dragelement, dropelement).build().perform();
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
	  driver.close();
  }

}
