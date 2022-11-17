/**
 * Determines patient color based on priorty 
 * @author Sabina Johnson
 * @version 1.0
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PatientView extends JPanel {
	private int patientID;
	private int priority;

	/**
	 * Constructor that takes patient ID and priority level as a parameter
	 * @param patientID
	 * @param priority
	 */
	public PatientView(int patientID, int priority) {
		setPatientID(patientID);
		setPriority(priority);
		
		JLabel patientIDLabel = new JLabel(Integer.toString(patientID));
		add(patientIDLabel);
		setBackground(Color.white);
		
        setVisible(true);
	}

	/**
	 * Getter for patient ID
	 */
	public int getPatientID() {
		return patientID;
	}

	/**
	 * Setter for patient ID
	 */
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	/**
	 * Getter for priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Setter for priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Adds oval shape and color based on priority for each patient
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	 Graphics2D person = (Graphics2D) g;
	 
	 person.setColor(getPriorityColor());
	 
	 person.fillOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
	}
	
	/**
	 * Set color based on patient's priority level
	 * @return red, orange, yellow, or green
	 */
	public Color getPriorityColor() {
		if (priority == 1) {
			return Color.red;
		} else if (priority == 2) {
			return Color.orange;
		} else if (priority == 3) {
			return Color.yellow;
		} else {
			return Color.green;
		}
	}
}
