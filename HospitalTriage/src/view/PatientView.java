package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PatientView extends JPanel {
	private int patientID;
	private int priority;
	private final static int WIDTH = 30;
	private final static int HEIGHT = 30;

	public PatientView(int patientID, int priority) {
		setPatientID(patientID);
		setPriority(priority);
		
		JLabel patientIDLabel = new JLabel(Integer.toString(patientID));
		add(patientIDLabel);
		
        setVisible(true);
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public void paintComponent(Graphics g){
	 Graphics2D person = (Graphics2D) g;
	 
	 person.setColor(getPriorityColor());
	 
	 person.fillOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
	 
	 

	}
	
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
