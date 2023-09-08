package root;

import org.testng.annotations.Test;

public class AppTest {
	
	@Test(priority = 1)
	void signin() {
		System.out.println("signin");
	}
	@Test(priority = 2)
	void logout() {
		System.out.println("logout 1");
	}

	@Test(priority = 3,enabled = false)
	void signin2() {
		System.out.println("signin");
	}
	@Test(priority = 4)
	void logout2() {
		System.out.println("logout 2");
	}

	

}
