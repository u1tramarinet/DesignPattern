package visitor;

import java.util.Iterator;

public abstract class Visitor {
    public abstract void visit(File file);

    public void visit(Directory directory) {
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
    }
}
