package Exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Welcome to %s mortgage processor.%n", MortgageConstants.BANK_NAME);
        System.out.print("Enter current prime interest rate (e.g., enter 0.05 for 5%): ");
        double primeRate = 0.0;
        try {
            primeRate = Double.parseDouble(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid rate. Using 0.05 (5%).");
            primeRate = 0.05;
        }

        Mortgage[] mortgages = new Mortgage[3];

        for (int i = 0; i < mortgages.length; i++) {
            System.out.printf("\nCreating mortgage %d of %d.%n", i + 1, mortgages.length);
            System.out.print("Enter mortgage number: ");
            String number = sc.nextLine().trim();
            System.out.print("Enter customer name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter mortgage amount: ");
            double amount = 0.0;
            try {
                amount = Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid amount; using 0.");
            }

            System.out.print("Enter term (1=short, 3=medium, 5=long): ");
            int term = 1;
            try {
                term = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid term; using 1.");
            }

            System.out.print("Enter mortgage type (B=Business, P=Personal): ");
            String type = sc.nextLine().trim();

            if (type.equalsIgnoreCase("B")) {
                mortgages[i] = new BusinessMortgage(number, name, amount, term, primeRate);
            } else {
                mortgages[i] = new PersonalMortgage(number, name, amount, term, primeRate);
            }
        }

        System.out.println("\n--- All mortgages entered. Displaying info ---");
        for (Mortgage m : mortgages) {
            m.getMortgageInfo();
        }

        sc.close();
    }
}
