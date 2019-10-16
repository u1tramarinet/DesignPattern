package adapter.property.inheritance;

import adapter.property.FileIO;

import java.io.*;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {
    private final String header = "written by " + FileProperties.class.getSimpleName();

    public FileProperties() {
        super();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        InputStream in = new FileInputStream(filename);
        load(in);
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        OutputStream out = new FileOutputStream(filename);
        store(out, header);
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key);
    }
}
