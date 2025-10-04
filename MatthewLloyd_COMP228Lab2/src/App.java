

public class App {
    public static void main(String[] args) {
        //Comment out the test lines to get the lotto lines to run. not sure how to get them to run back to back but it wasn't working for me
        Test test = new Test();
        test.inputAnswer();
        Lotto lotto = new Lotto();
        lotto.play();
        System.out.println("\n" +Overloads.add(1,2));
        System.out.println(Overloads.add(1.1,2.2));
        System.out.println(Overloads.add(1.0,2.0,3.0));
    }
}