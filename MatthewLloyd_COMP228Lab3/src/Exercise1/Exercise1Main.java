package Exercise1;

import java.util.Scanner;

public class Exercise1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many insurance entries would you like to enter? ");
        int n = 0;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid number. Exiting.");
            sc.close();
            return;
        }

        Insurance[] arr = new Insurance[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Entry %d:\n", i + 1);
            System.out.print("Enter insurance type (Life/Health): ");
            String type = sc.nextLine().trim();
            System.out.print("Enter monthly fee: ");
            double fee = 0.0;
            try {
                fee = Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid fee. Using 0.0");
            }

            if (type.equalsIgnoreCase("Life")) {
                arr[i] = new Life(fee);
            } else {
                // default to Health if not Life
                arr[i] = new Health(fee);
            }
        }

        System.out.println("\n--- Applying polymorphic setInsuranceCost() and displaying info ---");
        for (Insurance ins : arr) {
            ins.setInsuranceCost();
            ins.displayInfo();
        }

        sc.close();
    }
}
