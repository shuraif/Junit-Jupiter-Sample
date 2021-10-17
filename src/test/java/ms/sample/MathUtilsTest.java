package ms.sample;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtil")
class MathUtilsTest {

	 MathUtils mathUtils;
	 TestInfo testInfo;
	 TestReporter testReporter;
	
	@BeforeAll//annotaion to execute test method before all other test methods
	public  void init(TestInfo testInfo,TestReporter testReporter) {

		mathUtils = new MathUtils();
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	}
	
	
	@Nested//nested annotation is used for grouping test method in nested group
	@DisplayName("add method")
	@Tag("Math")//tag annotation can used for grouping test methods
	class TestAdd{
		
		@Test
		@DisplayName("Testing for +ve numbers")//display name annotation is used to specify name to the test method
		void testAdd() {		
			int expected=2;
			int actual=mathUtils.add(1, 1);
			testReporter.publishEntry("Runnign "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
			assertEquals(expected,actual,"should return the right sum");
		}
		
		@Test
		@DisplayName("Testing for -ve numbers")
		void testAddNeagtive() {		
			
			assertEquals(-2,mathUtils.add(-1, -1),"should return the right sum");
		}
	}
	
	
	@Test
	@Tag("Math")
	void testDevide() {		
		
		assertThrows(ArithmeticException.class,()-> mathUtils.devide(100,0),"Devide by zero error");
		
		//fail()
	}	
	
	@Test
	@DisplayName("Multiply method")
	@Tag("Math")
	public void testMultiply() {		
			
		System.out.println("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
		assertAll(
				()->assertEquals(4, mathUtils.multiply(2, 2)),
				()->assertEquals(6, mathUtils.multiply(2, 3)),
				()->assertEquals(21, mathUtils.multiply(7, 3))
						
				);
	}	
	
	@Test
	@Tag("Circle")
	void testComputeCircleArea() {
		
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10)," Should retun circle area");
	}
	
	@Test
	@Disabled//disabled annotation is used for skipping the test. This will be useful in test driven development.
	@DisplayName("Test driven development")
	void testDisabled() {
		
		fail("Failed");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)//Annotation for executing test method only in specific OS 
	@DisplayName("Test method only for linux")
	public void testOnlyInLinux() {
		
		System.out.println("Test method only for linux");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	@DisplayName("Test method only for windows")
	public void testOnlyInWindows() {
		
		System.out.println("Test method only for windows");
	}
	
	@Test
	@DisplayName("Assume sample")
	public void assumeExample() {
		boolean flag=true;
		
		assumeTrue(flag);//act as a if condition. code below this statement will execute only if the flag is true
		System.out.println("Flag is true");
		
	}
	
	
	@RepeatedTest(3)//annotation for executing a test method repeatedly
	public void repeatedTest(RepetitionInfo rep) {
		
		System.out.println("Repetition "+rep.getCurrentRepetition()+" of "+ rep.getTotalRepetitions());
		
		if (rep.getCurrentRepetition() == 2) {
			System.out.println("This will print only in second repetition");
		}
		
	}
	
}
