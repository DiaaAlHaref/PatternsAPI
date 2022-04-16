package FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static String[] propertiesFileReader(String[] data){
        String[] dataFile = new String[data.length];
        Properties properties = new Properties();

        try {
            InputStream input = new FileInputStream("src/test/resources/DataDriven/data.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=0; i< data.length; i++){
            dataFile[i] = properties.getProperty(data[i]);
        }


        return dataFile;
    }
}
