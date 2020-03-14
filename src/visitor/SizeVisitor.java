package visitor;

public class SizeVisitor extends Visitor {
    private int size = 0;

    @Override
    public void visit(File file) {
        size += file.getSize();
    }

    public int getSize() {
        return size;
    }
}
