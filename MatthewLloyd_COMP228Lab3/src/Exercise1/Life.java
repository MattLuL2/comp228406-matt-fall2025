package Exercise1;

public class Life extends Insurance {
    private double inputFee;

    public Life(double inputFee) {
        super("Life");
        this.inputFee = inputFee;
    }

    @Override
    public void setInsuranceCost() {
        // For this simple assignment we set the monthly cost to the user-provided fee.
        this.monthlyCost = inputFee;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Insurance Type: %s, Monthly Cost: $%.2f%n", getInsuranceType(), getMonthlyCost());
    }
}
