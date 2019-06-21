package basics.JuneSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver(); //open browser
		
		driver.manage().window().maximize(); //maximize the window
		
		driver.get("https://www.seleniumhq.org/"); // open website
		
		Thread.sleep(3000); //wait
		
		driver.close(); //close the browser
	}

}
