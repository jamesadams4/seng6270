package edu.ecu.ppcs;

public class PhotoCostCalculatorMode1 implements PhotoCostCalculator {

	@Override
	public double getSizeCost(int quantity, String size) {
		if (size.equals("4 x 6")) {
			if (quantity >= 1 && quantity <= 50) {
				return 0.14 * quantity;
			} else if (quantity >= 51 && quantity <= 75) {
				return 0.12 * quantity;
			} else if (quantity >= 76 && quantity <= 100) {
				return 0.10 * quantity;
			}
		} else if (size.equals("5 x 7")) {
			if (quantity >= 1 && quantity <= 50) {
				return 0.34 * quantity;
			} else if (quantity >= 51 && quantity <= 75) {
				return 0.31 * quantity;
			} else if (quantity >= 76 && quantity <= 100) {
				return 0.28 * quantity;
			}
		} else if (size.equals("8 x 10")) {
			if (quantity >= 1 && quantity <= 50) {
				return 0.68 * quantity;
			} else if (quantity >= 51 && quantity <= 75) {
				return 0.64 * quantity;
			} else if (quantity >= 76 && quantity <= 100) {
				return 0.60 * quantity;
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

	@Override
	public double getPromoDiscount(int quantity, String promoCode) {
		if (quantity == 100 && promoCode.equals("N56M2")) {
			return -2.00;
		}
		return 0.0;
	}

	@Override
	public double getQuantityCost(int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
