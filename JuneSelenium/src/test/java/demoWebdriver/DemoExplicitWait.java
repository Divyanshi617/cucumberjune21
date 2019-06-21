package demoWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoExplicitWait {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	  driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("divyanshi");
	  driver.findElement(By.xpath("//span[@class='RveJvd snByac'][contains(.,'Next')]")).click();
	  WebDriverWait wait=new WebDriverWait(driver,30);
	  WebElement paswrd=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type,'password')]")));
	  Assert.assertNotNull(paswrd);
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
