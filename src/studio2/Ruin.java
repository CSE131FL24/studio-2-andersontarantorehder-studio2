package studio2;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfDays =500;
		int successCount = 0;
		int ruinCount = 0;
		double startAmount = 2;
		double winChance = 0.7;
		double winLimit = 10;

		for (int i = 0; i < numberOfDays; i++) {

			double balance = startAmount;



			int totalSimulations = 0;
			while ((0 < balance) && (balance < winLimit)) {


				boolean didTheyWin = (Math.random() <= winChance);
				if (didTheyWin) {
					balance = balance + 1;


				}
				else {
					balance = balance - 1;

				}
				totalSimulations++;

			}

			System.out.println("Total simulations for one day: " + totalSimulations);
			if (balance == winLimit) {
				System.out.println("Success");
				successCount++;
			}
			else {
				System.out.println("Ruin");
				ruinCount++;
			}
		}

		System.out.println("Over " + numberOfDays + " days, you succeeded " + successCount + " times and ruined " + ruinCount +" times.");
		double expectedRuin50 = (1 - (startAmount/winLimit));
		System.out.println("Expected Ruin: " + expectedRuin50);
		double alpha = ((1-winChance)/winChance);
		double normalExpectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
		System.out.println("Ruin chance " + normalExpectedRuin);
	}
}

