package ms.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

	static MathUtils mathUtils;
	
	@BeforeAll
	public static void init() {
		mathUtils=new MathUtils();
	}
	
	@Test
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
	
	
}
