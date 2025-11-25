package Exercise3;

public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String mortgageNumber, String customerName, double amount, int term, double primeRate) {
        super(mortgageNumber, customerName, amount, term);
        // Business mortgages: interest = primeRate + 1% (0.01)
        this.interestRate = primeRate + 0.01;
    }
}
