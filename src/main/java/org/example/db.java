package org.example;
import java.util.Properties;
public class db {
        public static void main(String[] args) {
            Properties props = new Properties();

            props.setProperty("db.url", "jdbc:postgresql://localhost:5432/mydb");
            props.setProperty("db.user", "jeff");
            props.setProperty("app.env", "development");

            String dbUrl = props.getProperty("db.url");
            System.out.println("DB URL: " + dbUrl);

            String logLevel = props.getProperty("log.level", "INFO");
            System.out.println("Log level" + logLevel);

            props.remove("app.env");
            System.out.println("app.env after remove: " + props.getProperty("app.env"));
        }
}
