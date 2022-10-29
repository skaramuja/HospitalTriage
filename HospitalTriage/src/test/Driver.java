package test;

import java.util.PriorityQueue;

import model.EmergencyRoom;
import model.Patient;

public class Driver {
	
	public static void main(String[] args) {
		EmergencyRoom EmergencyRoom = new EmergencyRoom();
		PriorityQueue<Patient> patients = EmergencyRoom.addPateintsToER();
		// Loop through Priority Queue and print 
		while(!patients.isEmpty()) {
			Patient patient = patients.poll();
			System.out.println(patient);
		}

	}

}
