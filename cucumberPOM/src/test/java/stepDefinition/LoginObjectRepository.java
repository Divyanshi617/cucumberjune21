package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjectRepository {
	
	WebDriver driver;
	public LoginObjectRepository(WebDriver driver)
	{
		PageFactory.initElements(driver, LoginObjectRepository.class);
	}
	
	

	@FindBy(name="username")
	public static WebElement usern;
	
	@FindBy(name="password")
	public static WebElement passw;
	
	@FindBy(className="radius")
	public static WebElement login;
	
}

//to be written in test script inside step definition.

//@when("user enters username an dpassword")
//LoginOR repository=new LoginOR(driver);
//repository.usern.sendKeys("tomsmith");
//repository.passw.sendKeys("supersecretpassword");
//repository.login.click();
