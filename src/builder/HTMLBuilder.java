package builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import util.FilePathUtils;

public class HTMLBuilder implements Builder {

    private String filename = FilePathUtils.getOutPath();
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        filename += title + ".html";

        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        print("<html><head><title>").print(title).println("</title></head><body>");

        print("<h1>").print(title).println("</h1>");
    }

    @Override
    public void makeString(String str) {
        print("<p>").print(str).println("</p>");
    }

    @Override
    public void makeItems(String[] items) {
        println("<ul>");
        for (int i = 0; i < items.length; i++) {
            print("<li>").print(items[i]).println("</li>");
        }
        println("</ul>");
    }

    @Override
    public void close() {
        println("</body></html>");
        writer.close();
    }

    public String getFilename() {
        return filename;
    }

    private HTMLBuilder print(String s) {
        if (writer != null) {
            writer.print(s);
        }
        return this;
    }

    private HTMLBuilder println(String s) {
        if (writer != null) {
            writer.println(s);
        }
        return this;
    }
}
