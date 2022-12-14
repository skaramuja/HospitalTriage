/**
 * EmergencyRoom class that adds patients based on priority (Priority Queue)
 * @author Sabina Johnson
 * @version 1.0
 */

package model;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class EmergencyRoom {
	private final int MAX_CAPACITY = 70;
	private final int NEW_PATIENTS = 20;
	private PriorityQueue<Patient> patients = new  PriorityQueue<Patient>();
	private final int HIGHEST_PRIORITY = 1;
	private final int LOWEST_PRIORITY = 4;
	
	/**
	 * Default constructor with no parameters
	 */
	public EmergencyRoom() {
		addPatientsToER(MAX_CAPACITY);
	}
	
	/**
	 * Generates a random number of patients, assigns a priority, and adds them to the emergency room
	 * @param maxPatients
	 */
	private void addPatientsToER(int maxPatients) {
		int numPatients = (int) (Math.random() * maxPatients) + 1;
		for (int i = 0; i < numPatients; i++) {
			int priority = (int) (Math.random() * LOWEST_PRIORITY) + HIGHEST_PRIORITY;
			Patient patient = new Patient(priority);
			patients.add(patient);
		}
	}
	
	/**
	 * Add new patients to the emergency room
	 */
	public void addNewPatientsToER() {
		int numPatients = (int) (Math.random() * NEW_PATIENTS) + 1;
		addPatientsToER(numPatients);
	}
	
	/**
	 * Retrieves and removes the top priority patient (head of the priority queue)
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
	 * Convert a Queue to a List
	 * @return patients
	 */
	public LinkedList<Patient> getEmergencyRoomPatients(){
		return new LinkedList<Patient>(patients);
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
