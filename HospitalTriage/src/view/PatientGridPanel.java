package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Patient;

public class PatientGridPanel extends JPanel {
	private ArrayList<Patient> patients = new ArrayList<Patient>();

	/**
	 * Constructor with no parameters
	 */
	public PatientGridPanel() {	
		GridLayout layout = new GridLayout(6, 10, 1, 1);
		setLayout(layout);
		setBackground(Color.white);
	}

	/**
	 * Getter for patients
	 */
	public ArrayList<Patient> getPatients() {
		return patients;
	}

	/**
	 * Setter for patients
	 */
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
		removeAll();
		for (int i = 0; i < patients.size(); i++) {
			Patient patient = patients.get(i);
			PatientView patientView = new PatientView(patient.getPatientID(), patient.getPriority());
			add(patientView);
		}
		repaint();
		revalidate();
	}
	
	
}
