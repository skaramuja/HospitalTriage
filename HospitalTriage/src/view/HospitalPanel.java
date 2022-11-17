/**
 * Create a panel for hospital
 * @author Sabina Johnson
 * @version 1.0
 */

package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Patient;

public class HospitalPanel extends JPanel{
	private PatientGridPanel patientGridPanel = new PatientGridPanel();

	
	/**
	 * Constructor with no parameters that creates an hospital panel
	 * Set layout, title, and background
	 */
	public HospitalPanel() {		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		setBorder(BorderFactory.createTitledBorder("Hospital"));
		add(patientGridPanel);
		
		setBackground(Color.white);
		
		setVisible(true);
	}

	/**
	 * Setter for patients
	 */
	public void setPatients(LinkedList<Patient> patients) {
		patientGridPanel.setPatients(patients);

	}
}
