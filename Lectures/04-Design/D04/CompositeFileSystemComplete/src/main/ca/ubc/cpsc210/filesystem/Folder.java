package ca.ubc.cpsc210.filesystem;

import java.util.ArrayList;
import java.util.List;

// Represents a folder
public class Folder extends FileSystemResource {
    private List<FileSystemResource> children;

    public Folder(String name) {
        super(name);
        children = new ArrayList<>();
    }

    /**
     * Add a file system resource to this folder
     *
     * @param fsr the file system resource to add.
     */
    public void addChild(FileSystemResource fsr) {
        if (!children.contains(fsr)) {
            children.add(fsr);
        }
    }

    @Override
    protected void print(int indent) {
        printIndent(indent);
        System.out.println("Folder: " + this.name);
        for (FileSystemResource fsr : children) {
            fsr.print(indent + 1);
        }
    }
}
