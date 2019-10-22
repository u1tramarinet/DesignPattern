package abstractfactory.tablefactory;

import abstractfactory.factory.*;

public class TableTray extends Tray {

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<td>");
        builder.append("<table width=\"100%\" border=\"1\"><tr>");
        builder.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"")
                .append(tray.size()).append("\"><b>")
                .append(caption).append("</b></td>");
        builder.append("</tr>\n");
        builder.append("<tr>\n");
        for (Item item : tray) {
            builder.append(item.makeHTML());
        }
        builder.append("</tr></table>");
        builder.append("</td>");
        return builder.toString();
    }
}
