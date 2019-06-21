package testngFeatures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssertEqulas {
	@Test
	public void test1() {
		int exp=50;
		int act=50;
		Assert.assertEquals(act, exp,"error msg 1");
	}

	@Test
	public void test2() {
		Assert.assertEquals("hello","welcome","error msg 1");
	}
	@Test
	public void test3() {
		Object test=null;
		Assert.assertNull(test, "object not null");
	}
	@Test
	public void test4() {
		Assert.fail("failing this test");
	}




}
