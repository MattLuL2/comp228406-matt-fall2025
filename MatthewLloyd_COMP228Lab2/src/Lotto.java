import java.util.Random;
import javax.swing.JOptionPane;

public class Lotto {
    private int[] numbers;
    private static final Random rand = new Random();

    public Lotto() {
        numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = rand.nextInt(9) + 1; // 1..9
        }
    }

    public int[] getNumbers() {
        return numbers.clone();
    }

    public int sum() {
        int s = 0;
        for (int n : numbers) s += n;
        return s;
    }

    @Override
    public String toString() {
        return numbers[0] + ", " + numbers[1] + ", " + numbers[2];
    }

    public void play(){
        int target = -1;
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Choose a number between 3 and 27:", "Lotto Game", JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            try {
                target = Integer.parseInt(input.trim());
                if (target >= 3 && target <= 27) break;
            } catch (NumberFormatException e) {
            }
            JOptionPane.showMessageDialog(null, "Please enter a valid integer between 3 and 27.", "Invalid", JOptionPane.ERROR_MESSAGE);
        }

        boolean won = false;
        StringBuilder log = new StringBuilder();
        for (int roll = 1; roll <= 5; roll++) {
            Lotto lotto = new Lotto();
            int sum = lotto.sum();
            log.append(String.format("Roll %d: [%s] Sum = %d\n", roll, lotto.toString(), sum));
            if (sum == target) {
                JOptionPane.showMessageDialog(null, String.format("You won on roll %d! Lotto: [%s] Sum = %d", roll, lotto.toString(), sum), "Winner", JOptionPane.INFORMATION_MESSAGE);
                won = true;
                break;
            }
        }

        if (!won) {
            JOptionPane.showMessageDialog(null, "Sorry, you did not match the target within 5 rolls.\n\nRolls:\n" + log.toString(), "Computer wins", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
