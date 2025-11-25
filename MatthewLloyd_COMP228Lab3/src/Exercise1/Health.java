package Exercise1;

public class Health extends Insurance {
    private double inputFee;

    public Health(double inputFee) {
        super("Health");
        this.inputFee = inputFee;
    }

    @Override
    public void setInsuranceCost() {
        // Assign the user-provided fee as the monthly cost.
        this.monthlyCost = inputFee;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Insurance Type: %s, Monthly Cost: $%.2f%n", getInsuranceType(), getMonthlyCost());
    }
}
