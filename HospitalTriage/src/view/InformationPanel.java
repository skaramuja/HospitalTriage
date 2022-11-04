package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.SimulationControlHandler;
import model.Patient;

public class InformationPanel extends JPanel {
	private PatientGridPanel patientGridPanel = new PatientGridPanel();
	private final static int CYCLE_BUTTON_WIDTH = 10;
	private final static int CYCLE_BUTTON_HEIGHT = 10;
	private SimulationControlHandler simulationControlHandler;
	private int emergencyRoomPatients = 0;
	private int hospitalPatients = 0;
	private int dischargedPatients= 0;
	
	private int priortyHighTotal = 0;
	private int priortyMediumHighTotal= 0;
	private int priortyMediumLowTotal = 0;
	private int priortyLowTotal= 0;
	
	JLabel emergencyRoomLabel = new JLabel("ER: " + 0);
	JLabel hospitalLabel = new JLabel("Hospital: " + 0);
	JLabel dischargeLabel = new JLabel("Discharged: " + 0);
	
	JLabel priortyHigh = new JLabel("Priorty 1: " + 0);
	JLabel priortyMediumHigh = new JLabel("Priorty 2: " + 0);
	JLabel priortyMediumLow = new JLabel("Priorty 3: " + 0);
	JLabel priortyLow = new JLabel("Priorty 4: " + 0);

	/**
	 * Display program information in new panel for each cycle
	 * @param emergencyRoomPatients
	 * @param hospitalPatients
	 * @param dischargedPatients
	 */
	public InformationPanel() {
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		setBorder(BorderFactory.createTitledBorder("Patients Served"));
		add(patientGridPanel);
		layout.setHgap(30);

		// Add labels
		add(emergencyRoomLabel);
		setVisible(true);

		add(hospitalLabel);
		setVisible(true);

		add(dischargeLabel);
		setVisible(true);
		
		add(priortyHigh);
		setVisible(true);
		
		add(priortyMediumHigh);
		setVisible(true);
		
		add(priortyMediumLow);
		setVisible(true);
		
		add(priortyLow);
		setVisible(true);

		// Add cycle button
		Button cycleButton = new Button();
		cycleButton.setSize(CYCLE_BUTTON_WIDTH, CYCLE_BUTTON_HEIGHT);
		cycleButton.setLabel("Cycle");
		add(cycleButton);

		// Add reset button
		Button resetButton = new Button();
		resetButton.setSize(CYCLE_BUTTON_WIDTH, CYCLE_BUTTON_HEIGHT);
		resetButton.setLabel("Reset");
		add(resetButton);

		// Add action listener
		CycleClickListener c = new CycleClickListener();
		cycleButton.addActionListener(c);

		ResetListener r = new ResetListener();
		resetButton.addActionListener(r);

	}
	
	public void setPatients(ArrayList<Patient> patients) {
		int highTotal = 0;
		int mediumHighTotal = 0;
		int mediumLowTotal = 0;
		int lowTotal = 0;
		for(int i = 0; i < patients.size(); i++) {
			if(patients.get(i).getPriority() == 1) {
				++highTotal;
			} else if (patients.get(i).getPriority() == 2) {
				++mediumHighTotal;
			} else if (patients.get(i).getPriority() == 3) {
				++mediumLowTotal;
			} else if (patients.get(i).getPriority() == 4) {
				++lowTotal;
			}
		}
		setPriortyHighTotal(highTotal);
		setPriortyMediumHighTotal(mediumHighTotal);
		setPriortyMediumLowTotal(mediumLowTotal);
		setPriortyLowTotal(lowTotal);
	}
	
	public void setPriortyHighTotal(int priortyHighTotal) {
		this.priortyHighTotal = priortyHighTotal;
		priortyHigh.setText("Priorty 1: " + priortyHighTotal);
	}
	
	public void setPriortyMediumHighTotal(int priortyMediumHighTotal) {
		this.priortyMediumHighTotal = priortyMediumHighTotal;
		priortyMediumHigh.setText("Priorty 2: " + priortyMediumHighTotal);
	}
	
	public void setPriortyMediumLowTotal(int priortyMediumLowTotal) {
		this.priortyMediumLowTotal = priortyMediumLowTotal;
		priortyMediumLow.setText("Priorty 3: " + priortyMediumLowTotal);
	}
	
	public void setPriortyLowTotal(int priortyLowTotal) {
		this.priortyLowTotal = priortyLowTotal;
		priortyLow.setText("Priorty 4: " + priortyLowTotal);
	}
	
	public void setEmergencyRoomPatients(int emergencyRoomPatients) {
		this.emergencyRoomPatients = emergencyRoomPatients;
		emergencyRoomLabel.setText("ER: " + emergencyRoomPatients);
	}
	
	public int getEmergencyRoomPatients() {
		return emergencyRoomPatients;
	}

	public int getHospitalPatients() {
		return hospitalPatients;
	}

	public void setHospitalPatients(int hospitalPatients) {
		this.hospitalPatients = hospitalPatients;
		hospitalLabel.setText("Hospital: " + hospitalPatients);
	}

	public int getDischargedPatients() {
		return dischargedPatients;
	}

	public void setDischargedPatients(int dischargedPatients) {
		this.dischargedPatients = dischargedPatients;
		dischargeLabel.setText("Discharged: " + dischargedPatients);
	}

	/**
	 * Getter for SymulationControlHandler
	 */
	public SimulationControlHandler getSymulationControlHandler() {
		return simulationControlHandler;
	}

	/**
	 * Setter for SymulationControlHandler
	 */
	public void setSymulationControlHandler(SimulationControlHandler symulationControlHandler) {
		this.simulationControlHandler = symulationControlHandler;
	}

	/**
	 * Class that implements actionListener to handle cycle button press
	 * @param e
	 */
	class CycleClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			simulationControlHandler.handleNextCycle();
		}
	}

	/**
	 * Class that implements actionListener to handle reset button press
	 * @param e
	 */
	class ResetListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			simulationControlHandler.handleReset();
		}
	}

}
