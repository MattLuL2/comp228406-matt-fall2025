import java.util.Scanner;
import java.util.Random;

public class Test {
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private int answer1;
    private int answer2;
    private int answer3;
    private int answer4;
    private int userAnswer;
    private int questionNumber;
    private int correct;
    private int incorrect;
    private static final Scanner scanner = new Scanner(System.in);

    public Test() {
        this.question1 = "\nWhat is a class in Java?";
        this.question2 = "\nWhat is a private field?";
        this.question3 = "\nWhat is a constructor?";
        this.question4 = "\nWhat is a method?";
        this.answer1 = 1;
        this.answer2 = 2;
        this.answer3 = 3;
        this.answer4 = 4;
        this.userAnswer = 0;
        this.questionNumber = 1;
        this.correct = 0;
        this.incorrect =0;
    }

    public void printQuestion(int questionNumber) {
        switch (questionNumber) {
            case 1:
                System.out.println(question1);
                System.out.println("\n1) A blueprint that defines the data (fields) and behavior (methods) of objects you can create from it.");
                System.out.println("2) A place for the program to learn new things.");
                System.out.println("3) A type of loop that repeats code until a condition is met.");
                System.out.println("4) A command-line tool used to compile Java programs.");
                break;
            case 2:
                System.out.println(question2);
                System.out.println("\n1) A variable that can be accessed from anywhere.");
                System.out.println("2) A variable that can only be accessed within its own class.");
                System.out.println("3) A method that returns private data automatically.");
                System.out.println("4) A field that stores data only during program startup.");
                break;
            case 3:
                System.out.println(question3);
                System.out.println("\n1) A method that is called when an object is destroyed.");
                System.out.println("2) A loop that constructs arrays.");
                System.out.println("3) A special method used to initialize objects.");
                System.out.println("4) A keyword that defines the access level of a class.");
                break;
            case 4:
                System.out.println(question4);
                System.out.println("\n1) A type of Java comment.");
                System.out.println("2) A storage location for data in a class.");
                System.out.println("3) A special symbol used for arithmetic operations.");
                System.out.println("4) A block of code that performs a specific task and can be called on objects.");
                break;
            default:
                break;
        }
    }

    public boolean checkAnswer(int questionNumber, int userAnswer) {
        switch (questionNumber) {
            case 1:
                return userAnswer == answer1;
            case 2:
                return userAnswer == answer2;
            case 3:
                return userAnswer == answer3;
            case 4:
                return userAnswer == answer4;
            default:
                return false;
        }

    }

    public void inputAnswer() {
        boolean flag = true;

        while (flag) {
            if (this.questionNumber > 4) {
                flag = false;
            } else {
                printQuestion(this.questionNumber);

                int input = -1;
                while (true) {
                    System.out.print("\nEnter your answer (1-4): ");
                    if (!scanner.hasNext()) {
                        System.out.println("\nNo more input. Ending quiz.");
                        displayResults();
                        return;
                    }
                    if (scanner.hasNextInt()) {
                        input = scanner.nextInt();
                        if (input >= 1 && input <= 4) {
                            break;
                        } else {
                            System.out.println("Please enter a number between 1 and 4.");
                        }
                    } else {
                        String bad = scanner.next();
                        System.out.println("Invalid input: '" + bad + "'. Please enter a number between 1 and 4.");
                    }
                }

                this.userAnswer = input;

                if (checkAnswer(this.questionNumber, this.userAnswer)) {
                    this.correct++;
                    generateMessage(true);
                }

                else {
                    this.incorrect++;
                    generateMessage(false);
                }
 

                this.questionNumber++;
            }

        }

        displayResults();

    }

    public void generateMessage(boolean isCorrect) {
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        if (isCorrect) {
            switch (randomNum) {
                case 0:
                    System.out.println("\nExcellent!");
                    break;
                case 1:
                    System.out.println("\nGood!");
                    break;
                case 2:
                    System.out.println("\nKeep up the good work!");
                    break;
                case 3:
                    System.out.println("\nNice Work!");
                    break;
            }
        } else {
            switch (randomNum) {
                case 0:
                    System.out.println("\nNo. Please try again.");
                    break;
                case 1:
                    System.out.println("\nWrong. Try once more.");
                    break;
                case 2:
                    System.out.println("\nDon't give up!");
                    break;
                case 3:
                    System.out.println("\nNo. Keep trying.");
                    break;
            }
        }
    }

    public void displayResults() {
        System.out.println("\nTest Completed! Thank you for participating.\n");
        System.out.println("Correct Answers: " + this.correct);
        System.out.println("Incorrect Answers: " + this.incorrect);
        System.out.println("Percentage: " + ((double)this.correct / (this.correct + this.incorrect) * 100) + "%");
    }
}
