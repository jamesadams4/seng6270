package edu.ecu.ppcs;

public class PhotoCostCalculatorMode1 implements PhotoCostCalculator {

	@Override
	public double getSizeCost(int quantity, String size) {
		double total = 0;
		if (size.equals("4 x 6")) {
			if (quantity >= 1 && quantity <= 50) {
				total += 0.14 * quantity;
				return total;
			} else if (quantity >= 51 && quantity <= 75) {
				total += 0.14 * 50;
				total += 0.12 * (quantity-50);
				return total;
			} else if (quantity >= 76 && quantity <= 100) {
				total += 0.14 * 50;
				total += 0.12 * 25;
				total += 0.10 * (quantity-75);
				return total;
			}
		} else if (size.equals("5 x 7")) {
			if (quantity >= 1 && quantity <= 50) {
				total += 0.34 * quantity;
				return total;
			} else if (quantity >= 51 && quantity <= 75) {
				total += 0.34 * 50;
				total += 0.31 * (quantity-50);
				return total;
			} else if (quantity >= 76 && quantity <= 100) {
				total += 0.34 * 50;
				total += 0.31 * 25;
				total += 0.28 * (quantity-75)
				return total;
			}
		} else if (size.equals("8 x 10")) {
			if (quantity >= 1 && quantity <= 50) {
				total += 0.68 * quantity;
				return total;
			} else if (quantity >= 51 && quantity <= 75) {
				total += 0.68 * 50;
				total += 0.64 * (quantity-50);
				return total;
			} else if (quantity >= 76 && quantity <= 100) {
				total += 0.68 * 50;
				total += 0.64 * 25;
				total += 0.60 * (quantity-75);
				return total;
			}
		}
		return 0.0;
	}

	@Override
	public double getFinishCost(int quantity, String finish, String size) {
		if (finish.equals("matte")) {
			if (size.equals("4 x 6")) {
				return 0.02 * quantity;
			} else if (size.equals("5 x 7")) {
				return 0.03 * quantity;
			} else if (size.equals("8 x 10")) {
				return 0.04 * quantity;
			}
		}
		return 0.0;
	}

	@Override
	public double getProcessingTimeCost(int quantity, String processingTime) {
		if (processingTime.equals("1-Hour")) {
			if (quantity >= 1 && quantity <= 60) {
				return 1.00;
			} else if (quantity >= 61 && quantity <= 100) {
				return 1.50;
			}
		}
		return 0.0;
	}

	public double getPromoDiscount(int quantity, String promoCode) {
		if (quantity == 100 && promoCode.equals("N56M2")) {
			return -2.00;
		}
		return 0.0;
	}

}
