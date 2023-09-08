package root.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations2 {
	@AfterSuite
	void afterSuite() {
		System.out.println("after-suite");
	}
	
	
	@BeforeTest
	void b4Test() {
		System.out.println("before-test-2");
	}

	@AfterTest
	void afterTest() {
		System.out.println("after-test-2");
	}
	
	@BeforeClass
	void b4Class() {
		System.out.println("before-class-2");
	}

	@AfterClass
	void afterClass() {
		System.out.println("after-class-2");
	}

	@BeforeMethod
	void preCondition() {
		System.out.println("pre-condition-2");
	}

	@AfterMethod
	void postCondition() {
		System.out.println("post-condition-2");
	}

	@Test(priority = 1)
	void signUp() {
		System.out.println("	sign up-2");
	}

	@Test(priority = 2)
	void signIn() {
		System.out.println("	sign in-2");
	}

	@Test(priority = 4 , groups = {"log in"})
	void logIn() {
		System.out.println("	log in-2");
	}

	@Test(priority = 3)
	void logOut() {
		System.out.println("	log out-2");
	}

}
