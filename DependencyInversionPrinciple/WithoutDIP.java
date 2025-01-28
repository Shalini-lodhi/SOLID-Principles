class MySQLDatabase {
    public void connect() {
        System.out.println("Connecting to MySQL database...");
    }
}

class Application {
    private MySQLDatabase database;

    public Application() {
        this.database = new MySQLDatabase();
    }

    public void start() {
        database.connect();
    }
}

public class WithoutDIP {
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
