/**
 * Hospital class that adds patients to hospital beds
 * @author Sabina Johnson
 * @version 1.0
 */

package model;

import java.util.LinkedList;

public class Hospital {
	private final int MAX_CAPACITY = 50;
	private LinkedList<Patient> patients = new LinkedList<Patient>();
	private String status = "Hospital";

	/**
	 * Default constructor with no parameters
	 */
	public Hospital() {

	}

	/**
	 * Getter for patients
	 */
	public LinkedList<Patient> getPatients() {
		return patients;
	}

	/**
	 * Setter for patients
	 */
	public void setPatients(LinkedList<Patient> patients) {
		this.patients = patients;
	}

	/**
	 * Determines available beds in the hospital
	 * @return integer representing open beds
	 */
	public int openBeds() {
		return MAX_CAPACITY - patients.size();
	}

	/**
	 * Determines occupied beds in the hospital
	 * @return integer representing occupied beds
	 */
	public int occupiedBeds() {
		return patients.size();
	}

	/**
	 * Determines if hospital is full
	 * @return boolean
	 */
	public boolean isFull() {
		return occupiedBeds() == MAX_CAPACITY;

	}

	/**
	 * Admit patient to hospital
	 */
	public void admit(Patient patient) {
		patient.setStatus(status);
		patients.add(patient);
	}

	/**
	 * Discharges patient from hospital
	 * @return patient that was discharged
	 */
	public Patient discharge() {
		int index = (int) (Math.random() * occupiedBeds() - 1);
		return patients.remove(index);

	}

	@Override
	public String toString() {
		return "Hospital [patients=" + getPatients() + "]";
	}
}
