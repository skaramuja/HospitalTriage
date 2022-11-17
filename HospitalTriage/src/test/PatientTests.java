/**
 * JUnit testing for patient model
 * @author Sabina Johnson
 * @version 1.0
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Patient;

class PatientTests {
	Patient unitUnderTest;
	int priority = 2;

	@BeforeEach
	void setUp() throws Exception {
		unitUnderTest = new Patient(priority);
	}
	
	@Test
	void tylerTestPriority() {
		int actual = unitUnderTest.getPriority();
		int expected = priority;
		assertEquals(actual, expected);
	}
	
	@Test
	void testSetStatus() {
		String expected = "Hospital";
		unitUnderTest.setStatus(expected);
		String actual = unitUnderTest.getStatus();
		assertEquals(actual, expected);
		
	}
	
	@Test
	void testCompareToHigherPriority() {
		Patient patient = new Patient(1);
		int actual = unitUnderTest.compareTo(patient);
		int expected = 1;
		assertEquals(actual, expected);
		
	}
	
	@Test
	void testCompareToEqualPriority() {
		Patient patient = new Patient(2);
		int actual = unitUnderTest.compareTo(patient);
		int expected = -1;
		assertEquals(actual, expected);
	}
	
	@Test
	void testCompareToLowerPriority() {
		Patient patient = new Patient(3);
		int actual = unitUnderTest.compareTo(patient);
		int expected = -1;
		assertEquals(actual, expected);
	}

}
