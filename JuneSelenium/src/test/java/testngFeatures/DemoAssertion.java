package testngFeatures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssertion {

	@Test
	public void test1() {
		System.out.println("test 1 started");
		Assert.assertTrue(20>18, "error msg 1");
		System.out.println("test 1 completed");
	}

	@Test
	public void test2() {
		System.out.println("test 2 started");
		Assert.assertTrue(20<18, "error msg 2");
		System.out.println("test 2 completed");
	}

	@Test
	public void test3() {
		System.out.println("test 3 started");
		Assert.assertFalse("hello".equals("hi"), "error msg-both values are different");
		System.out.println("test 3 completed");
	}

}
