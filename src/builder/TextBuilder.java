package builder;

public class TextBuilder implements Builder {

    private static final String LINE = "==============================\n";
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append(LINE);
        buffer.append("『").append(title).append("』\n");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append("■").append(str).append("\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append("　・").append(items[i]).append("\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append(LINE);
    }

    public String getResult() {
        return buffer.toString();
    }
}
