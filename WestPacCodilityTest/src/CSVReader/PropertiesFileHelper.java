package CSVReader;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileHelper {
    public static final String APPLICATION_PROPERTIES="resources/application.properties";
    public static final String CSV_FILE_NAME_KEY="csv.file.name";
    public static final String CSV_FILE_PATH="csv.file.path";
    public static final String DEFAULT_FILE_NAME="default.csv";

    public static String csvFileNameFromProperties() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        try( InputStream resourceStream = loader.getResourceAsStream(APPLICATION_PROPERTIES)){
            props.load(resourceStream);
            return props.getProperty(CSV_FILE_NAME_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return DEFAULT_FILE_NAME;
        }
    }
    public static String csvFilePathFromProperties() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        try(InputStream resourceStream = loader.getResourceAsStream(APPLICATION_PROPERTIES)){
            props.load(resourceStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props.getProperty(CSV_FILE_PATH);
    }
}