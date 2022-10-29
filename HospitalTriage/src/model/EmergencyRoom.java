/**
 * EmergencyRoom class that adds patients to a Priority Queue
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
		
	}
	
	/**
	 * Generates a random number of patients, assigns a priority, and adds them to the Priority Queue  
	 * @return patients
	 */
	public PriorityQueue addPateintsToER() {
		int numPatients = (int) (Math.random() * MAX_CAPACITY);
		for (int i = 0; i < numPatients; i++) {
			int priority = (int) (Math.random() * LOWEST_PRIORITY) + HIGHEST_PRIORITY;
			Patient patient = new Patient(priority);
			patients.add(patient);
		}
		
		return patients;
	}

}
