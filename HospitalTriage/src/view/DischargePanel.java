package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Patient;

public class DischargePanel extends JPanel {
	private PatientGridPanel patientGridPanel = new PatientGridPanel();


	/**
	 * Constructor with no parameters that creates an discharged panel
	 */
	public DischargePanel() {
		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		JLabel label = new JLabel("Discharge");

		add(label);
		add(patientGridPanel);

		setBackground(Color.green);

		setVisible(true);
	}

	public void setPatients(ArrayList<Patient> patients) {
		patientGridPanel.setPatients(patients);

	}

}
