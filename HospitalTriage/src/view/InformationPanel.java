package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationPanel extends JPanel{
	private final static int CYCLE_BUTTON_WIDTH = 10;
	private final static int CYCLE_BUTTON_HEIGHT = 10;
	
	/**
	 * Display program information in new panel for each cycle
	 * @param emergencyRoomPatients
	 * @param hospitalPatients
	 * @param dischargedPatients
	 */
	public InformationPanel(int emergencyRoomPatients, int hospitalPatients, int dischargedPatients) {
		GridLayout layout = new GridLayout(1, 5, 10, 10);
		setLayout(layout);
		setBackground(Color.pink);
		
		// Add labels 
		JLabel emergencyRoomLabel = new JLabel("ER: " + emergencyRoomPatients);
		add(emergencyRoomLabel);
		setVisible(true);
		
		JLabel hospitalLabel = new JLabel("Hospital: " + hospitalPatients);
		add(hospitalLabel);
		setVisible(true);
		
		JLabel dischargeLabel = new JLabel("Discharged: " + dischargedPatients);
		add(dischargeLabel);
		setVisible(true);
		
		// Add button
		Button cycleButton = new Button();
		cycleButton.setSize(CYCLE_BUTTON_WIDTH, CYCLE_BUTTON_HEIGHT);
		cycleButton.setLabel("Cycle");
		add(cycleButton);
		
		Button resetButton = new Button();
		resetButton.setSize(CYCLE_BUTTON_WIDTH, CYCLE_BUTTON_HEIGHT);
		resetButton.setLabel("Reset");
		add(resetButton);
	
	}
}
