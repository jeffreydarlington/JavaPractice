package org.example;

import java.util.Iterator;
import java.util.Objects;
import java.util.Properties;

public class IterateProperties {
    public static void main(String[] args){
        Properties props = new Properties();
        props.setProperty("name", "Jeff");
        props.setProperty("role", "Junior Developer");
        props.setProperty("goal", "Cybersecurity");

        Iterator<Object> keys = props.keySet().iterator();
        while (keys.hasNext()){
            String key = (String) keys.next();
            System.out.println(key + " = " + props.getProperty(key));
        }
    }
}
