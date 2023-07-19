package ca.ubc.cpsc210.filesystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Represents a folder
public class Folder extends FileSystemResource {

    private List<FileSystemResource> children;

    public Folder(String name) {
        super(name);
        children = new ArrayList<>();
    }

    @Override
    public void print() {
        System.out.println("Folder: " + name);
        for (FileSystemResource f : children) {
            System.out.print("\t");
            f.print();
        }

    }

    public void addChild(FileSystemResource fsr) {
        if (!children.contains(fsr)) {
            children.add(fsr);
        }
    }
}
