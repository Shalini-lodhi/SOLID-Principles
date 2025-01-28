interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }

    @Override
    public void eat() {
        // Robots don't eat, but forced to implement
        throw new UnsupportedOperationException("Robot can't eat");
    }
}

public class WithoutISP {
    public static void main(String[] args) {
        Worker robot = new Robot();
        robot.work();
        try {
            robot.eat(); // Throws exception
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
