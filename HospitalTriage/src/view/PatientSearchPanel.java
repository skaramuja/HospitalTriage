/**
 * Display search panel and handle user validation for input
 * @author Sabina Johnson
 * @version 1.0
 */

package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Patient;

import java.util.LinkedHashMap;
import java.awt.*;
import java.awt.event.*;

public class PatientSearchPanel extends JFrame {
	private String typedText = null;
	private JTextField textField;
	private LinkedHashMap<Integer, Patient> patientsHashMap;
	private final static int CYCLE_BUTTON_WIDTH = 10;
	private final static int CYCLE_BUTTON_HEIGHT = 10;
	private JLabel searchLabel = new JLabel("Search Patient by ID: ");
	private JLabel resultLabel = new JLabel("");

	/**
	 * Constructor takes a hash map of patients and displays search box
	 */
	public PatientSearchPanel(LinkedHashMap<Integer, Patient> patientsHashMap) {
		this.patientsHashMap = patientsHashMap;

		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		add(searchLabel);

		// Add text field for user input
		textField = new JTextField(10);
		add(textField);

		// Add search button
		Button searchButton = new Button();
		searchButton.setSize(CYCLE_BUTTON_WIDTH, CYCLE_BUTTON_HEIGHT);
		searchButton.setLabel("Search");
		add(searchButton);

		// Add cancel button
		Button cancelButton = new Button();
		cancelButton.setSize(CYCLE_BUTTON_WIDTH, CYCLE_BUTTON_HEIGHT);
		cancelButton.setLabel("Cancel");
		add(cancelButton);

		add(resultLabel);

		// Add Action Listener
		CancelButton c = new CancelButton();
		cancelButton.addActionListener(c);

		SearchListener s = new SearchListener();
		searchButton.addActionListener(s);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Class that implements actionListener to handle search button press
	 * @param e
	 */
	class SearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			typedText = textField.getText();
			if (typedText.isBlank()) { // Validation if field is blank
				resultLabel.setText("Error: missing patient ID to search (Please enter a numeric Patient ID).");
			} else {
				try {
					int patientID = Integer.parseInt(typedText);
					Patient patient = patientsHashMap.get(patientID);
					if (patient != null) {
						resultLabel.setText("Result: " + patient.toString()); // update result label
					} else {
						resultLabel.setText("Error: patient not found (Please eneter another ID)"); // Validate if ID not found
					}
				} catch (Exception exception) { // Validate that field contains numeric value
					resultLabel.setText(
							"Error: " + typedText + " is not a valid input (Please enter a numeric Patient ID).");
				}
			}

			repaint();
			revalidate();
		}
	}

	/**
	 * Class that implements actionListener to handle cancel button press
	 * @param e
	 */
	class CancelButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}
