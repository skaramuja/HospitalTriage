package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.EmergencyRoom;
import model.EmergencyRoomEmptyException;
import model.Patient;

class EmergencyRoomTests {
	EmergencyRoom unitUnderTest;

	@BeforeEach
	void setUp() throws Exception {
		unitUnderTest = new EmergencyRoom();
	}

	@Test
	void testEmergencyRoom() {
		int actual = unitUnderTest.getEmergencyRoomPatients().size();
		assertTrue(actual > 0);
	}

	@Test
	void testGetNextPriorityPatient() throws EmergencyRoomEmptyException {
		Patient actual = unitUnderTest.getNextPriorityPatient();
		assertTrue(actual != null);
	}

	@Test
	void testGetEmergencyRoomPatients() {
		int actual = unitUnderTest.getEmergencyRoomPatients().size();
		assertTrue(actual > 0);
	}

	@Test
	void testIsEmpty() throws EmergencyRoomEmptyException {
		while(!unitUnderTest.isEmpty()) {
			unitUnderTest.getNextPriorityPatient();
		}
		boolean actual = unitUnderTest.isEmpty();
		assertTrue(actual);
	}

}
