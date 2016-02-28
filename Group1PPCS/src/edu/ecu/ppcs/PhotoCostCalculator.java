package edu.ecu.ppcs;

public interface PhotoCostCalculator {
	public double getSizeCost(int quantity, String size);
	
	public double getFinishCost(int quantity, String finish, String size);
	
	public double getProcessingTimeCost(int quantity, String processingTime);
	
	public double getPromoDiscount(int quantity, String promoCode);
}
