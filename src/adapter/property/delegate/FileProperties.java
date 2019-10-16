package adapter.property.delegate;

import adapter.property.FileIO;

import java.io.*;
import java.util.Properties;

public class FileProperties implements FileIO {
    private final String header = "written by " + adapter.property.inheritance.FileProperties.class.getSimpleName();

    private Properties properties;

    public FileProperties() {
        this.properties = new Properties();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        InputStream in = new FileInputStream(filename);
        properties.load(in);
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        OutputStream out = new FileOutputStream(filename);
        properties.store(out, header);
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
