package com.myapp.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //    This class will read configuration.properties file using JAVA
//    create Properties object
    private static Properties properties;

    //    static block
    static {
        String path = "configuration.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    Create method that accepts KEY and returns VALUE
    public static String getProperty(String key) {  //it reads properties file
        String value = properties.getProperty(key);
        return value;


    }
////just testing getProperty method
//    public static void main(String[] args) {
//
//        System.out.println(ConfigReader.getProperty("amazon_regression_url")); //https://www.regression-amazon-52asdf6a.com
//        System.out.println(ConfigReader.getProperty("amazon_prod_url")); //https://www.amazon.com
//    }

}