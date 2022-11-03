package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Patient;

public class EmergencyRoomPanel extends JPanel {
	private PatientGridPanel patientGridPanel = new PatientGridPanel();
	
	/**
	 * Constructor with no parameters that creates an emergency room panel
	 */
	public EmergencyRoomPanel() {
		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		JLabel label = new JLabel("Emergency Room");

		add(label);
		add(patientGridPanel);

		setBackground(Color.red);

		setVisible(true);
	}

	public void setPatients(ArrayList<Patient> patients) {
		patientGridPanel.setPatients(patients);
		
	}

}
