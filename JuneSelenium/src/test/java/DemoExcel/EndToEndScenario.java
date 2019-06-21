package DemoExcel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class EndToEndScenario {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  driver.findElement(By.xpath("//a[contains(.,'SignIn')]")).click();//click on signin
	  driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("lalitha");//username
	  driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("password123");//password
	  driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();//submit button
	  
	  
	  //searching from search box
	  
	  WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"myInput\"]"));
	  Actions act=new Actions(driver);
	  
	 act.keyDown(searchbox, Keys.SHIFT).perform();
	 act.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").perform();
	 
	 Thread.sleep(3000);
	 act.moveToElement(driver.findElement(By.xpath("(//div[contains(.,'Hand bag')])[4]"))).click();
	 driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	 Thread.sleep(3000);
	  
	  
	  //searching from all categories tab

//	  WebElement allcategories=driver.findElement(By.xpath("//span[contains(.,'All\n" + 
//	  		"										Categories')]"));//categories
//	  //Actions act=new Actions(driver);
//	  act.moveToElement(allcategories).click().pause(1000).perform();//hover
//	  
//	  WebElement homeappliances =driver.findElement(By.xpath("//span[contains(.,'Home Appliances')]"));//homeappliances hover
//	  act.moveToElement(homeappliances).click().pause(1000).perform();
//	  driver.findElement(By.xpath("//span[@onclick='getProducts(11292,112106)'][contains(.,'Floor')]")).click();//floor
	  
	  driver.findElement(By.xpath("//a[contains(@class,'btn btn-success btn-product')]")).click();//add to cart
	  
	  driver.findElement(By.xpath("//a[contains(@style,'color:green')]")).click();//cart 1
	  
	  driver.findElement(By.xpath("//a[contains(@class,'btn btn-success btn-block')]")).click();//checkout
	  
	  driver.findElement(By.xpath("//textarea[@name='ShippingAdd']")).sendKeys("magarpatta");//shipping address
	  
	  driver.findElement(By.xpath("//input[contains(@value,'Proceed to Pay')]")).click();//proceed to pay
	  
	  Thread.sleep(4000);
	  
	  driver.findElement(By.xpath("//label[contains(.,'Andhra Bank')]")).click();//radio button
	  
	  driver.findElement(By.xpath("//a[contains(@onclick,'radioValue()')]")).click();//continue
	  
	  driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("123456");//username
	  
	  driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("Pass@456");//password
	  
	  driver.findElement(By.xpath("//input[contains(@value,'LOGIN')]")).click();//login
	  
	  driver.findElement(By.xpath("//input[contains(@style,'border:2px solid gray;width:280px;color:black')]")).sendKeys("Trans@456");//transaction password
	  
	  driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();//submit
	  
	  String text=driver.findElement(By.xpath("//p[contains(.,'Your order has been confirmed')]")).getText();
	  
	  Assert.assertTrue(text.contains("Your order has been confirmed"));
	  
	  
	  
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
