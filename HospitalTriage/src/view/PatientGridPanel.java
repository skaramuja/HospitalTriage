/**
 * Display patients to the view
 * @author Sabina Johnson
 * @version 1.0
 */

package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JPanel;

import model.Patient;

public class PatientGridPanel extends JPanel {
	private LinkedList<Patient> patients = new LinkedList<Patient>();

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
	public LinkedList<Patient> getPatients() {
		return patients;
	}

	/**
	 * Setter for patients that adds patients to the view
	 */
	public void setPatients(LinkedList<Patient> patients) {
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
