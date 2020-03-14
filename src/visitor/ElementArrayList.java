package visitor;

import java.util.ArrayList;

public class ElementArrayList extends ArrayList<Entry> implements Element {
    @Override
    public void accept(Visitor visitor) {
        for (Entry entry : this) {
            entry.accept(visitor);
        }
    }
}
