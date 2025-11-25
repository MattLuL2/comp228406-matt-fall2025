package Exercise3;

public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String mortgageNumber, String customerName, double amount, int term, double primeRate) {
        super(mortgageNumber, customerName, amount, term);
        // Personal mortgages: interest = primeRate + 2% (0.02)
        this.interestRate = primeRate + 0.02;
    }
}
