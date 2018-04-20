

public class RaceCarRunner {
	public static void main(String[] args) {
		/* Do the following things without changing the RaceCar class */
		
		// 1. Create a RaceCar and place it in 5th position
		RaceCar rc = new RaceCar("dmc", 5);
	
		// 3. Get the RaceCar to print its position in the race.
		System.out.print("my position is: " + rc.getPositionInRace());

		// 4. Crash the RaceCar
		rc.crash();
		
		// 5. If the car is damaged. Bring it in for a pit stop.
		if( rc.damaged == true ) {
			rc.pit();
		}

		// 6. Help the car move into first place.
		while( rc.getPositionInRace() > 1 ) {
			rc.overtake();
		}

	}
}
