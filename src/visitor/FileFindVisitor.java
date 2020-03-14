package visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {
    private String extension;
    private List<File> foundFiles = new ArrayList<>();

    public FileFindVisitor(String extension) {
        this.extension = extension;
    }

    @Override
    public void visit(File file) {
        String fileName = file.getName();
        if (fileName.endsWith(extension)) {
            foundFiles.add(file);
        }
    }

    public Iterator<File> getFoundFiles() {
        return foundFiles.iterator();
    }
}
