package edu.ecu.ppcs;

public class PhotoCostCalculatorMode2 implements PhotoCostCalculator {
	

	public double getSizeCost(int quantity, String size) {
		double sum1 =0;
		double sum2=0;
		double sum3=0;
		if (size.equals("4 x 6")) 
			sum1 = quantity * 0.19;
			
		if (size.equals("5 x 7")) 
			sum2 = quantity * 0.36;
		
		 if (size.equals("8 x 10"))
			 
			 sum3 = quantity * 0.79; 
		 
		return (sum1 + sum2 + sum3);
		
	}

	@Override
	public double getFinishCost(int quantity, String finish, String size) {
		if (finish.equals("matte")) {
			if (size.equals("4 x 6")) {
				return 0.04 * quantity;
			} else if (size.equals("5 x 7")) {
				return 0.06 * quantity;
			} else if (size.equals("8 x 10")) {
				return 0.08 * quantity;
			}
		}
		return 0.0;
		
	}
	@Override
	public double getQuantityCost(int quantity) {
		
			if (quantity >= 1 && quantity <= 60) {
			
				return 2.00;
			}
			 else if (quantity >= 61 && quantity <= 100){ 
				return 2.50;
			 }
	
		return 0.0;
	
}

	@Override
	public double getProcessingTimeCost(int quantity, String processingTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPromoDiscount(int quantity, String promoCode) {
		// TODO Auto-generated method stub
		return 0;
	}
}