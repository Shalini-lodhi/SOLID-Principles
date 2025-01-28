interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database...");
    }
}

class MongoDBDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to MongoDB database...");
    }
}

class Application {
    private Database database;

    public Application(Database database) {
        this.database = database;
    }

    public void start() {
        database.connect();
    }
}

public class WithDIP {
    public static void main(String[] args) {
        Database mySQL = new MySQLDatabase();
        Database mongoDB = new MongoDBDatabase();

        Application app1 = new Application(mySQL);
        app1.start();

        Application app2 = new Application(mongoDB);
        app2.start();
    }
}
