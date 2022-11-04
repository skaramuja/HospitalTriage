package controller;

import java.util.ArrayList;

import javax.lang.model.element.Element;

import model.Discharged;
import model.EmergencyRoom;
import model.EmergencyRoomEmptyException;
import model.Hospital;
import model.Patient;
import view.WorkFlowFrame;

public class WorkFlowController implements SimulationControlHandler {
	private EmergencyRoom emergencyRoom = new EmergencyRoom();
	private Hospital hospital = new Hospital();
	private Discharged discharged = new Discharged();
	WorkFlowFrame workFlowFrame = new WorkFlowFrame();


	/**
	 * Constructor with no parameters
	 */
	public WorkFlowController() {
		workFlowFrame.setEmergencyRoomPatient(emergencyRoom.getEmergencyRoomPatients());
		workFlowFrame.setSimulationControlHandler(this);
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

	/**
	 * Method that sorts discharges patients using insertion sort based on patient priority
	 */
	public void insertionSortDischargedPatients() {
		int n = discharged.getPatients().size();
		for (int i = 1; i < n; ++i) {
			Patient key = discharged.getPatients().get(i);
			int j = i - 1;

			while (j >= 0 && discharged.getPatients().get(j).getPriority() > key.getPriority()) {
				discharged.getPatients().set(j + 1, discharged.getPatients().get(j));
				j = j - 1;
			}
			discharged.getPatients().set(j + 1, key);
		}
	}

	@Override
	public void handleNextCycle() {
		if (hospital.occupiedBeds() > 0) {
			discharge(); // discharge patients prior to new admission
		}
		admit(); // admit new patients to hospital
		insertionSortDischargedPatients();
		workFlowFrame.setEmergencyRoomPatient(emergencyRoom.getEmergencyRoomPatients());
		workFlowFrame.setHospitalPatient(hospital.getPatients());
		workFlowFrame.setDischargePatient(discharged.getPatients());
	}

	@Override
	public void handleReset() {
		this.emergencyRoom = new EmergencyRoom();
		this.hospital = new Hospital();
		this.discharged = new Discharged();
		
		workFlowFrame.setEmergencyRoomPatient(emergencyRoom.getEmergencyRoomPatients());
		workFlowFrame.setHospitalPatient(new ArrayList<Patient>());
		workFlowFrame.setDischargePatient(new ArrayList<Patient>());
	}
}