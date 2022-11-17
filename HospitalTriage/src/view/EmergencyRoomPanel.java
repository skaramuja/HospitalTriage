/**
 * Create a panel for emergency room
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

public class EmergencyRoomPanel extends JPanel {
	private PatientGridPanel patientGridPanel = new PatientGridPanel();
	
	/**
	 * Constructor with no parameters that creates an emergency room panel
	 * Sets layout, title, and background
	 */
	public EmergencyRoomPanel() {
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		setBorder(BorderFactory.createTitledBorder("Emergency Room"));
		add(patientGridPanel);

		setBackground(Color.white);

		setVisible(true);
	}

	/**
	 * Setter for patients
	 */
	public void setPatients(LinkedList<Patient> patients) {
		patientGridPanel.setPatients(patients);
		revalidate();
	}

}
