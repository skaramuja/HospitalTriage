/**
 * Manages frame and panels 
 * @author Sabina Johnson
 * @version 1.0
 */

package view;

import java.awt.Color;
import java.awt.Container;
import java.util.LinkedList;

import javax.swing.JFrame;

import controller.SimulationControlHandler;
import model.Patient;

public class WorkFlowFrame extends JFrame{
	private EmergencyRoomPanel emergencyRoomPanel = new EmergencyRoomPanel();
	private HospitalPanel hospitalPanel = new HospitalPanel();
	private DischargePanel dischargePanel = new DischargePanel();
	private InformationPanel informationPanel = new InformationPanel(); 
	
	private final static int FRAME_WIDTH = 1017; 
	private final static int FRAME_HEIGHT = 740;
	private final static int PANEL_WIDTH = 1000;
	private final static int PANEL_HEIGHT = 200;
	private final static int X_COORDINATE = 0; 
	private final static int Y_COORDINATE = 0;
	
	/**
	 * Default constructor with no parameters
	 */
	public WorkFlowFrame() {
		setTitle("Hospital Triage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		Container container = getContentPane();
		
		// Set bounds for frame
		setBounds(X_COORDINATE, Y_COORDINATE, FRAME_WIDTH, FRAME_HEIGHT);
		
		// Set bounds for panels
		emergencyRoomPanel.setBounds(X_COORDINATE, PANEL_HEIGHT * 0, PANEL_WIDTH, PANEL_HEIGHT);
		hospitalPanel.setBounds(X_COORDINATE, PANEL_HEIGHT * 1, PANEL_WIDTH, PANEL_HEIGHT);
		dischargePanel.setBounds(X_COORDINATE, PANEL_HEIGHT * 2, PANEL_WIDTH, PANEL_HEIGHT);
		informationPanel.setBounds(X_COORDINATE, PANEL_HEIGHT * 3, PANEL_WIDTH, PANEL_HEIGHT / 2);
		
		// Add panels to the container
		container.add(emergencyRoomPanel);
		container.add(hospitalPanel);
		container.add(dischargePanel);
		container.add(informationPanel);

		// Set background color
		container.setBackground(Color.white);
		
		
		setVisible(true);
	}	
	
	/**
	 * Update emergency room panel and update information panel with number of patients in the emergency room 
	 */
	public void setEmergencyRoomPatient(LinkedList<Patient> patients) {
		emergencyRoomPanel.setPatients(patients);
		informationPanel.setEmergencyRoomPatients(patients.size());
	}
	
	/**
	 * Update hospital panel and update information panel with number of patients in the hospital
	 */
	public void setHospitalPatient(LinkedList<Patient> patients) {
		hospitalPanel.setPatients(patients);
		informationPanel.setHospitalPatients(patients.size());
	}
	
	/**
	 * Update discharge panel and update information panel with number of patients in the discharge 
	 */
	public void setDischargePatient(LinkedList<Patient> patients) {
		dischargePanel.setPatients(patients);
		informationPanel.setDischargedPatients(patients.size());
		informationPanel.setPatients(patients);

	}
	
	/**
	 * Setter for SimulationControlHandler
	 */
	public void setSimulationControlHandler(SimulationControlHandler simulationControlHandler) {
		informationPanel.setSymulationControlHandler(simulationControlHandler);
	}

}
