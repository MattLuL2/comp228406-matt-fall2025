package Exercise2;

public class PartTimeGameTester extends GameTester {
    private static final double HOURLY_RATE = 20.0;
    private int hours;

    public PartTimeGameTester(String name, int hours) {
        super(name, false);
        this.hours = hours;
    }

    @Override
    public double determineSalary() {
        return hours * HOURLY_RATE;
    }
}
