package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

///media/moaz/New Volume/QC/Automation/pom_dp_test/src/main/java/properties/userdata.properties

public class LoadProperties {
    //Load The properties file from folder
    public static Properties userData = loadProperties(System.getProperty("user.dir") +"//src//main//java//properties//userdata.properties//");

    private static Properties loadProperties(String path) {
        Properties pro = new Properties();
        //stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred :" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred :" + e.getMessage());
        }
        return pro;
    }
}
