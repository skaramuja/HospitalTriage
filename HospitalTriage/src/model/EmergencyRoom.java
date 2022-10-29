/**
 * EmergencyRoom class that adds patients based on priority (Priority Queue)
 * @author Sabina Johnson
 * @version 1.0
 */

package model;

import java.util.PriorityQueue;

public class EmergencyRoom {
	private final int MAX_CAPACITY = 100;
	private PriorityQueue<Patient> patients = new  PriorityQueue<Patient>();
	private final int HIGHEST_PRIORITY = 1;
	private final int LOWEST_PRIORITY = 4;
	
	/**
	 * Default constructor with no parameters
	 */
	public EmergencyRoom() {
		addPatientsToER();
	}
	
	/**
	 * Generates a random number of patients, assigns a priority, and adds them to the emergency room
	 * @return patients
	 */
	private void addPatientsToER() {
		int numPatients = (int) (Math.random() * MAX_CAPACITY);
		for (int i = 0; i < numPatients; i++) {
			int priority = (int) (Math.random() * LOWEST_PRIORITY) + HIGHEST_PRIORITY;
			Patient patient = new Patient(priority);
			patients.add(patient);
		}
	}
	
	/**
	 * Retrieves and removes the top priority patient
	 * @return patient
	 * @throws EmergencyRoomEmptyException
	 */
	public Patient getNextPriorityPatient() throws EmergencyRoomEmptyException {
		if (!patients.isEmpty()) {
			return patients.poll();
		} else {
			throw new EmergencyRoomEmptyException();
		}

	}
	
	/**
	 * Indicates if there are any patients in the emergency room
	 * @return boolean
	 */
	public boolean isEmpty() {
		return patients.isEmpty();

	}

	@Override
	public String toString() {
		return "EmergencyRoom [patients=" + patients + "]";
	}
}
