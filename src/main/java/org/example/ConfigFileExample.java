package org.example;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileExample {
    public static void main(String[] args){
        // Building the config
        Properties config = new Properties();
        config.setProperty("app.name", "MyPipeline");
        config.setProperty("app.port", "8080");

        // write it to disk
        try (FileWriter out = new FileWriter("config.properties")){
            config.store(out, "App configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load it back (as if the app just started up)
        Properties loaded = new Properties();
        try(FileReader in = new FileReader("config.properties")){
            loaded.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("#App configuration");
        System.out.println("Loaded port: " + loaded.getProperty("app.port"));
        System.out.println("Name : " + loaded.getProperty("app.name"));
    }
}
