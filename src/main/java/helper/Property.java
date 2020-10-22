package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
/**
 вспомогательный класс для получения данных из файла config.properties
 */
public class Property {

    public static String getPropByKey(String key) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src\\main\\resources\\config.properties");
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
            props.load(isr);
        } catch (FileNotFoundException e) {
            //log
            e.printStackTrace();
        } catch (IOException e) {
            //log
            e.printStackTrace();
        }
        return props.getProperty(key);
    }
}
