/**
 * Patient class that stores information and provides method to help determine priority 
 * @author Sabina Johnson
 * @version 1.0
 */

package model;

public class Patient implements Comparable<Patient> {
	private static int nextPatientID = 1000;
	private int patientID;
	private int priority;
	private String status = "Emergency Room";

	/**
	 * Constructor that takes priority as a parameter and assigns a patient id 
	 * @param priorty -Ranges between 1 - 4 (1 = highest and 4 = lowest) 
	 */
	public Patient(int priority) {
		setPriority(priority);
		setPatientID(nextPatientID++);
	}

	/**
	 * Getter for patient id
	 */
	public int getPatientID() {
		return patientID;
	}

	/**
	 * Setter for patient id
	 */
	private void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	/**
	 * Getter for priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Setter for priority
	 */
	private void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Getter for status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Setter for status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Override compareTo method to determine priority queue order for patients in ER
	 * @param other 
	 * @return negative integer, zero, or a positive integer 
	 */
	@Override
	public int compareTo(Patient other) {
		if (priority == other.priority) {
			if (patientID > other.patientID) {
				return 1;
			} else {
				return -1;
			}
		} else if (priority > other.priority) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Patient [ID: " + getPatientID() + ", Priority: " + getPriority() + ", Status=" + getStatus() + "]";
	}

}
