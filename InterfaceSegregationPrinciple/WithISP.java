interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }
}

class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}

public class WithISP {
    public static void main(String[] args) {
        Workable human = new Human();
        human.work();

        Eatable humanEater = new Human();
        humanEater.eat();

        Workable robot = new Robot();
        robot.work();
    }
}
