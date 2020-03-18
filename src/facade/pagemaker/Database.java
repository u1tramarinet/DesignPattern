package facade.pagemaker;

import util.FilePathUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Database {

    private Database() {
    }

    public static Properties getProperties(String dbName) {
        String filename = FilePathUtils.getDataPath()  + dbName + ".txt";
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return properties;
    }
}
