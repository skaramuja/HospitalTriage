/**
 * Workflow controller 
 * @author Sabina Johnson
 * @version 1.0
 */

package controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import model.Discharged;
import model.EmergencyRoom;
import model.EmergencyRoomEmptyException;
import model.Hospital;
import model.Patient;
import view.PatientSearchPanel;
import view.WorkFlowFrame;

public class WorkFlowController implements SimulationControlHandler {
	private EmergencyRoom emergencyRoom = new EmergencyRoom();
	private Hospital hospital = new Hospital();
	private Discharged discharged = new Discharged();
	private WorkFlowFrame workFlowFrame = new WorkFlowFrame();
	private LinkedHashMap<Integer, Patient> patientsHashMap = new LinkedHashMap<Integer, Patient>();


	/**
	 * Constructor with no parameters that adds patients to the emergency room and hash map
	 */
	public WorkFlowController() {
		LinkedList<Patient> patients = emergencyRoom.getEmergencyRoomPatients();
		workFlowFrame.setEmergencyRoomPatient(patients);
		workFlowFrame.setSimulationControlHandler(this);
		for(int i = 0; i < emergencyRoom.getEmergencyRoomPatients().size(); i++) {
			Patient patient = patients.get(i);
			patientsHashMap.put(patient.getPatientID(), patient);
		}
	}

	/**
	 * Admits patients into hospital while hospital is not full and patient waiting in emergency room
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

	/**
	 * Method that handles admitting and discharging patient for each cycle
	 */
	@Override
	public void handleNextCycle() {
		if (hospital.occupiedBeds() > 0) {
			discharge(); // discharge patients prior to new admission
		}
		admit(); // admit new patients to hospital
		insertionSortDischargedPatients();
		workFlowFrame.setEmergencyRoomPatient(emergencyRoom.getEmergencyRoomPatients());
		workFlowFrame.setHospitalPatient(hospital.getPatients());
		LinkedList<Patient> patientList = new LinkedList<Patient>(discharged.getPatients());
		workFlowFrame.setDischargePatient(patientList);
	}

	/**
	 * Override method that handles reset 
	 */
	@Override
	public void handleReset() {
		this.emergencyRoom = new EmergencyRoom();
		this.hospital = new Hospital();
		this.discharged = new Discharged();
		
		workFlowFrame.setEmergencyRoomPatient(emergencyRoom.getEmergencyRoomPatients());
		workFlowFrame.setHospitalPatient(new LinkedList<Patient>());
		workFlowFrame.setDischargePatient(new LinkedList<Patient>());
	}
	
	/**
	 * Override method that handles search 
	 */
	@Override
	public void handleSearch() {
		PatientSearchPanel patientSearchCustomDialog = new PatientSearchPanel(patientsHashMap);
		patientSearchCustomDialog.setTitle("Search Patients");
		patientSearchCustomDialog.setBounds(0, 0, 500, 200);
	}
}