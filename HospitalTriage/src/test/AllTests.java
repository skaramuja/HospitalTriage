package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ HospitalTests.class, PatientTests.class, DischargedTests.class, EmergencyRoomTests.class })

public class AllTests {

}
