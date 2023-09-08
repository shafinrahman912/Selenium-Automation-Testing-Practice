package root.listen;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ListenerTest {

	@Test
	void testSuccess() {
		System.out.println("Test Success !!!");
		String actualResult = "A";
		String expectedResult = "A";
		Assert.assertEquals(actualResult, expectedResult);
	
	}
	@Test
	void testFailure() {
		System.out.println("Test Failure !!!");
		String actualResult = "A";
		String expectedResult = "B";
		Assert.assertEquals(actualResult, expectedResult);
	
	}
	
	@Test
	void testSkip() {
		System.out.println("Test Skip !!!");
		throw new SkipException("testSkipped exeption....");
	}

}
