package facade.pagemaker;

import util.FilePathUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PageMaker {

    private PageMaker() {
    }

    public static void makeWelcomePage(String mailAddress, String fileName) {
        fileName = FilePathUtils.getOutPath() + fileName;
        try {
            Properties properties = Database.getProperties("maildata");
            String userName = properties.getProperty(mailAddress);
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Welcome to " + userName + "'s page!");
            writer.paragraph(userName + "のページへようこそ！");
            writer.paragraph("メール待っていますね。");
            writer.mailto(mailAddress, userName);
            writer.close();
            System.out.println(fileName + " is created for " + mailAddress + " (" + userName + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String fileName) {
        fileName = FilePathUtils.getOutPath() + fileName;
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Link Page");

            Properties properties = Database.getProperties("maildata");
            Set<Object> keys = properties.keySet();
            for (Object o : keys) {
                String key = (String) o;
                writer.link(key, properties.getProperty(key, "(Unknown)"));
            }

            writer.close();
            System.out.println(fileName + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
