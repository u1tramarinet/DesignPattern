package adapter.property.delegate;

import adapter.property.FileIO;
import adapter.property.FilePathUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO fileIO = new FileProperties();
        try {
            fileIO.readFromFile(FilePathUtils.getDataPath() + "\\" + "file.txt");
            System.out.println("year= " + fileIO.getValue("year"));

            fileIO.setValue("year", "2014");
            fileIO.setValue("month", "9");
            fileIO.setValue("day", "13");
            fileIO.writeToFile(FilePathUtils.getDataPath() + "\\" + "newFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
