package abstractfactory.tablefactory;

import abstractfactory.factory.*;

public class TablePage extends Page {

    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head><title>").append(title).append("</title></head>\n");
        builder.append("<body>\n");
        builder.append("<h1>").append(title).append("</h1>\n");
        builder.append("<table width=\"80%\" border=\"3\">\n");
        for (Item item : content) {
            builder.append("<tr>").append(item.makeHTML()).append("</tr>");
        }
        builder.append("</table>\n");
        builder.append("<hr><address>").append(author).append("</address>");
        builder.append("</body></html>\n");
        return builder.toString();
    }
}
