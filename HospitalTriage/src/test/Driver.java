package test;

import java.util.ArrayList;

import controller.WorkFlowController;
import model.Patient;
import view.WorkFlowFrame;

public class Driver {

	public static void main(String[] args) {
		WorkFlowController workFlow = new WorkFlowController();
		workFlow.startSimulation();
		
		WorkFlowFrame workFlowView = new WorkFlowFrame();
		
		ArrayList<Patient> patients = new ArrayList<Patient>();
		for (int i = 0; i < 101; i++) {
			Patient patient = new Patient(4);
			patients.add(patient);
		}
		
		workFlowView.setEmergencyRoomPatient(patients);
		workFlowView.setHospitalPatient(patients);
		workFlowView.setDischargePatient(patients);
		
	}

}
