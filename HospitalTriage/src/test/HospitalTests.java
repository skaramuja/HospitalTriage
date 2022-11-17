/**
 * JUnit testing for hospital model
 * @author Sabina Johnson
 * @version 1.0
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Hospital;
import model.Patient;

class HospitalTests {
	Hospital unitUnderTest;

	@BeforeEach
	void setUp() throws Exception {
		unitUnderTest = new Hospital();
	}

	@Test
	void testHospital() {
		int actual = unitUnderTest.getPatients().size();
		assertTrue(actual == 0);
	}

	@Test
	void testSetPatients() {
		Patient patient = new Patient(3);
		Patient patient1 = new Patient(2);
		LinkedList<Patient> patients = new LinkedList<Patient>();
		patients.add(patient);
		patients.add(patient1);
		unitUnderTest.setPatients(patients);
		assertEquals(patients, unitUnderTest.getPatients());
	}

	@Test
	void testOpenBeds() {
		Patient patient = new Patient(3);
		Patient patient1 = new Patient(2);
		LinkedList<Patient> patients = new LinkedList<Patient>();
		patients.add(patient);
		patients.add(patient1);
		unitUnderTest.setPatients(patients);
		int actual = unitUnderTest.openBeds();
		assertEquals(actual, 48);
	}

	@Test
	void testOccupiedBeds() {
		Patient patient = new Patient(3);
		Patient patient1 = new Patient(2);
		LinkedList<Patient> patients = new LinkedList<Patient>();
		patients.add(patient);
		patients.add(patient1);
		unitUnderTest.setPatients(patients);
		int actual = unitUnderTest.occupiedBeds();
		assertEquals(actual, 2);
	}

	@Test
	void testIsFull() {
		while(!unitUnderTest.isFull()) {
			Patient patient = new Patient(3);
			unitUnderTest.admit(patient);
		}
		assertTrue(unitUnderTest.isFull());
	}

	@Test
	void testAdmit() {
		Patient patient = new Patient(3);
		unitUnderTest.admit(patient);
		assertEquals(unitUnderTest.getPatients().get(0), patient);
	}

	@Test
	void testDischarge() {
		Patient patient = new Patient(3);
		Patient patient1 = new Patient(2);
		unitUnderTest.admit(patient);
		unitUnderTest.admit(patient1);
		unitUnderTest.discharge();
		equals(unitUnderTest.getPatients().size() == 1);
	}
}
