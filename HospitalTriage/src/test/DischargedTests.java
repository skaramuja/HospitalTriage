/**
 * JUnit testing for discharge model
 * @author Sabina Johnson
 * @version 1.0
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Discharged;
import model.Patient;

class DischargedTests {
	Discharged unitUnderTest;

	@BeforeEach
	void setUp() throws Exception {
		unitUnderTest = new Discharged();
	}

	@Test
	void testDischarged() {
		int actual = unitUnderTest.getPatients().size();
		assertTrue(actual == 0);
	}

	@Test
	void testSetPatients() {
		Patient patient = new Patient(3);
		Patient patient1 = new Patient(2);
		ArrayList<Patient> patients = new ArrayList<Patient>();
		patients.add(patient);
		patients.add(patient1);
		unitUnderTest.setPatients(patients);
		assertEquals(patients, unitUnderTest.getPatients());
	}

	@Test
	void testAddPatient() {
		Patient patient = new Patient(3);
		unitUnderTest.addPatient(patient);
		assertEquals(unitUnderTest.getPatients().get(0), patient);
	}

}
