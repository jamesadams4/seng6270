package edu.ecu.ppcs;

public class PhotoCostCalculatorMode2 implements PhotoCostCalculator {
	
	@Override
	public double getSizeCost(int quantity, String size) {
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		
		if (size.equals("4 x 6")) 
			sum1 = quantity * 0.19;
			
		if (size.equals("5 x 7")) 
			sum2 = quantity * 0.39;
		
		if (size.equals("8 x 10"))	 
			sum3 = quantity * 0.79; 
		 
		return (sum1 + sum2 + sum3);
		
	}

	@Override
	public double getFinishCost(int quantity, String finish, String size) {
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		
		if (finish.equals("matte")) {
			if (size.equals("4 x 6")) {
				sum1 = 0.04 * quantity;
			}
			if (size.equals("5 x 7")) {
				sum2 = 0.06 * quantity;
			}
			if (size.equals("8 x 10")) {
				sum3 = 0.08 * quantity;
			}
		}
		return (sum1 + sum2 + sum3);
		
	}

	@Override
	public double getProcessingTimeCost(int quantity, String processingTime) {
		if (processingTime.equals("1-Hour")) {
			if (quantity >= 1 && quantity <= 60) {
				return 2.00;
			} else if (quantity >= 61 && quantity <= 100){ 
				return 2.50;
			}
		}
		return 0.0;
	}
}