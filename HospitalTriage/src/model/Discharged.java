/**
 * Discharged class that marks patients as discharged (Linked List)
 * @author Sabina Johnson
 * @version 1.0
 */

package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Discharged {
	private String status = "Discharged";
	private ArrayList<Patient> patients = new ArrayList<Patient>();

	/**
	 * Default constructor with no parameters
	 */
	public Discharged() {

	}
	
	

	public ArrayList<Patient> getPatients() {
		return patients;
	}



	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
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
