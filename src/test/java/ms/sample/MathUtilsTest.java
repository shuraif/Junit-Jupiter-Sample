package ms.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	 MathUtils mathUtils;
	
	@BeforeAll
	public  void init() {
		mathUtils=new MathUtils();
	}
	
	@Test
	@DisplayName("Testing add method")//display name annotation is used to specify name to the test method
	void testAdd() {		
		int expected=2;
		int actual=mathUtils.add(1, 1);
		
		assertEquals(expected,actual,"The add method should add two numbers");
	}	
	
	
	@Test
	void testDevide() {		
		
		assertThrows(NullPointerException.class,()-> mathUtils.devide(1, 0),"Devide by zero error");
		
		//fail();
	}	
	
	@Test
	void testComputeCircleArea() {
		
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10)," Should retun circle area");
	}
	
	@Test
	@Disabled//disabled annotation is used for skipping the test. This will be useful in test driven development.
	@DisplayName("Test driven development")
	void testDisabled() {
		
		fail("Failed");
	}
	
	
}
