/**
 * Discharged class that marks patients as discharged (Linked List)
 * @author Sabina Johnson
 * @version 1.0
 */

package model;

import java.util.LinkedList;

public class Discharged {
	private String status = "Discharged";
	private LinkedList<Patient> patients = new LinkedList<Patient>();

	/**
	 * Default constructor with no parameters
	 */
	public Discharged() {

	}

	/**
	 * Mark a patient as discharged
	 * @param patient
	 */
	public void addPatient(Patient patient) {
		patient.setStatus(status);
		patients.add(patient);
	}

	@Override
	public String toString() {
		return "Discharged [patients=" + patients + "]";
	}
}
