package basictest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algebra.BasicOperations;

public class BasicOperationsUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAddition() {
		double result = BasicOperations.addition(1, 2);
		assertTrue("Addition: ", result==3);
	}

	@Test
	public final void testSubstraction() {
		double result = BasicOperations.substraction(2,1);
		assertTrue(result==1);
	}

	@Test
	public final void testMultiply() {
		double result = BasicOperations.multiply(2,1);
		assertTrue(result==2);
	}

	@Test
	public final void testDivision() {
		double result = BasicOperations.division(6,2);
		assertTrue(result==3);
	}

	@Test
	public final void testPower() {
		double result = BasicOperations.power(3,1);
		assertTrue(result==3);
	}

}
