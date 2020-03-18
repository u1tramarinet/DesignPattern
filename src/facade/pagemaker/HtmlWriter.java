package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        write("<html>");
        write("<head>");
        write("<title>" + title + "</title>");
        write("</head>");
        write("<body>\n");
        write("<h1>" + title + "</h1>\n");
    }

    public void paragraph(String msg) throws IOException {
        write("<p>" + msg + "</p>\n");
    }

    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    public void mailto(String mailAddress, String username) throws IOException {
        link("mailto:" + mailAddress, username);
    }

    public void close() throws IOException {
        write("</body>");
        write("</html>\n");
        writer.close();
    }

    private void write(String msg) throws IOException {
        writer.write(msg);
    }
}
