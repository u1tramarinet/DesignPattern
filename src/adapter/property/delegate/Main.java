package adapter.property.delegate;

import adapter.property.*;
import util.FilePathUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO fileIO = new FileProperties();
        try {
            fileIO.readFromFile(FilePathUtils.getDataPath() + "file.txt");
            System.out.println("year= " + fileIO.getValue("year"));

            fileIO.setValue("year", "2014");
            fileIO.setValue("month", "9");
            fileIO.setValue("day", "13");
            fileIO.writeToFile(FilePathUtils.getOutPath() + "newFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
