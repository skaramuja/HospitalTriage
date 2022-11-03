package controller;

import model.Discharged;
import model.EmergencyRoom;
import model.EmergencyRoomEmptyException;
import model.Hospital;
import model.Patient;

public class WorkFlowController {
	private EmergencyRoom emergencyRoom = new EmergencyRoom();
	private Hospital hospital = new Hospital();
	private Discharged discharged = new Discharged();

	/**
	 * Constructor with no parameters that adds patients to hospital
	 */
	public WorkFlowController() {
		System.out.println("Admitting patients...");
		System.out.println("Patients in Emergency Room: " + emergencyRoom.toString());
		System.out.println("Patients in Hospital: " + hospital.toString());
		System.out.println("Discharged Patients: " + discharged.toString());
		System.out.println();
		
		admit();
		System.out.println("Patients in Emergency Room: " + emergencyRoom.toString());
		System.out.println("Patients in Hospital: " + hospital.toString());
		System.out.println("Discharged Patients: " + discharged.toString());
		System.out.println();

	}

	/**
	 * Starts hospital triage simulation by discharging and admitting patients
	 */
	public void startSimulation() {
		int numberOfIterations = 0;
		while (hospital.occupiedBeds() != 0) {
			discharge(); // discharge patients prior to new admission
			admit(); // admit new patients to hospital
			System.out.println("Iteration: " + numberOfIterations);
			System.out.println("Patients in Emergency Room: " + emergencyRoom.toString());
			System.out.println("Patients in Hospital: " + hospital.toString());
			System.out.println("Discharged Patients: " + discharged.toString());
			System.out.println();
			numberOfIterations++;
		}
		
		System.out.println("Patients in Emergency Room: " + emergencyRoom.toString());
		System.out.println("Patients in Hospital: " + hospital.toString());
		System.out.println("Discharged Patients: " + discharged.toString());
	}

	/**
	 * Admits patients into hospital while hospital is not full and patient waiting
	 * in emergency room
	 */
	public void admit() {
		while (!emergencyRoom.isEmpty() && !hospital.isFull()) {
			try {
				hospital.admit(emergencyRoom.getNextPriorityPatient());
			} catch (EmergencyRoomEmptyException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Discharge patients from hospital and mark patients as discharged
	 */
	public void discharge() {
		int numPatients = (int) (Math.random() * hospital.occupiedBeds());
		for (int i = 0; i <= numPatients; i++) {
			Patient patient = hospital.discharge();
			discharged.addPatient(patient);
		}
	}

	public void dischargedSort() {
		// TODO
	}
}