package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Patient;

public class PatientGridPanel extends JPanel {
	private ArrayList<Patient> patients = new ArrayList<Patient>();

	public PatientGridPanel() {	
		GridLayout layout = new GridLayout(6, 10, 1, 1);
		setLayout(layout);
		setBackground(Color.red);
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
		for (int i = 0; i < patients.size(); i++) {
			Patient patient = patients.get(i);
			PatientView patientView = new PatientView(patient.getPatientID(), patient.getPriority());
			add(patientView);
		}
		
		revalidate();
	}
	
	
}
