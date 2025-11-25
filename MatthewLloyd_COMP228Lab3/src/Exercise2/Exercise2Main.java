package Exercise2;

import java.util.Scanner;

public class Exercise2Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Game Tester Demo");
        System.out.print("Enter tester name: ");
        String name = sc.nextLine().trim();

        System.out.print("Choose type (1=Full-Time, 2=Part-Time): ");
        String choice = sc.nextLine().trim();

        GameTester tester;
        if (choice.equals("1")) {
            tester = new FullTimeGameTester(name);
            tester.displayInfo();
        } else {
            System.out.print("Enter number of hours worked (part-time): ");
            int hours = 0;
            try {
                hours = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid hours, using 0.");
            }
            tester = new PartTimeGameTester(name, hours);
            tester.displayInfo();
        }

        sc.close();
    }
}
