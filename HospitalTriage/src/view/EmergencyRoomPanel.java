package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
		setBorder(BorderFactory.createTitledBorder("Emergency Room"));
		add(patientGridPanel);

		setBackground(Color.white);

		setVisible(true);
	}

	public void setPatients(ArrayList<Patient> patients) {
		patientGridPanel.setPatients(patients);
		revalidate();
	}

}
