package root.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	@BeforeSuite
	void b4Suite() {
		System.out.println("before-suite");
	}
	
	@BeforeTest
	void b4Test() {
		System.out.println("before-test");
	}

	@AfterTest
	void afterTest() {
		System.out.println("after-test");
	}

	@BeforeClass
	void b4Class() {
		System.out.println("before-class");
	}

	@AfterClass
	void afterClass() {
		System.out.println("after-class");
	}

	@BeforeMethod
	void preCondition() {
		System.out.println("pre-condition");
	}

	@AfterMethod
	void postCondition() {
		System.out.println("post-condition");
	}

	@Test(priority = 1)
	void signUp() {
		System.out.println("	sign up");
	}

	@Test(priority = 2)
	void signIn() {
		System.out.println("	sign in");
	}

	@Test(priority = 4 , groups = {"log in", "sr"})
	void logIn() {
		System.out.println("	log in");
	}

	@Test(priority = 3, groups = {"log in"})
	void logOut() {
		System.out.println("	log out");
	}

}
