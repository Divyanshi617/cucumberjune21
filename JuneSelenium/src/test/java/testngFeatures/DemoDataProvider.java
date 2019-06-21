package testngFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DemoDataProvider {
	@Test(dataProvider = "credentials")
	public void login(String username, String password) {
		System.out.println("username is"+username);
		System.out.println("password is"+password);
	}

	@DataProvider(name="credentials")
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "selenium", "basic" },
			new Object[] { "divyanshi", "agarwal" },
			new Object[] { "mercury", "mercury" },
		};
	}
}
