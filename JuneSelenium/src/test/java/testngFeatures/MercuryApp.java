package testngFeatures;

import org.testng.annotations.Test;

public class MercuryApp {
	@Test(priority=1)
	public void openBrowser() {
		System.out.println("this is an open browser");
	}

	@Test(priority=2)
	public void OpenURL() {
		System.out.println("this is an open URL");
	}

	@Test(priority=3)
	public void login() {
		System.out.println("this isloginr");
	}

	@Test(priority=4,enabled=false)
	public void searchFlight() {
		System.out.println("this is search flight");
	}

	@Test(priority=5)
	public void bookFlight() {
		System.out.println("this is book flight");
	}

	@Test(priority=6)
	public void logout() {
		System.out.println("this is for logout");
	}
	@Test(priority=7)
	public void closeBrowser() {
		System.out.println("this is close browser");
	}

}
