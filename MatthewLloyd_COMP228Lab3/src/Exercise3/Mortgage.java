package Exercise3;

public abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate; // annual rate as decimal, e.g., 0.05 for 5%
    protected int term; // in years

    public Mortgage(String mortgageNumber, String customerName, double amount, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        if (amount > MAX_MORTGAGE) {
            System.out.printf("Amount exceeds max (%.2f). Setting to max.\n", MAX_MORTGAGE);
            this.amount = MAX_MORTGAGE;
        } else {
            this.amount = amount;
        }

        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            System.out.println("Invalid term entered; using short-term (1 year).");
            this.term = SHORT_TERM;
        }
    }

    public String getMortgageNumber() {
        return mortgageNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    public double getTotalOwed() {
        // Simple interest over the term: amount + amount * interestRate * term
        return amount + (amount * interestRate * term);
    }

    public void getMortgageInfo() {
        System.out.println("-------------------------------------");
        System.out.printf("Bank: %s%n", BANK_NAME);
        System.out.printf("Mortgage Number: %s%n", mortgageNumber);
        System.out.printf("Customer Name: %s%n", customerName);
        System.out.printf("Principal Amount: $%.2f%n", amount);
        System.out.printf("Interest Rate (annual): %.2f%%%n", interestRate * 100);
        System.out.printf("Term (years): %d%n", term);
        System.out.printf("Total Owed (principal + interest): $%.2f%n", getTotalOwed());
    }
}
