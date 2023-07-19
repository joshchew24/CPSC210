package ca.ubc.cpsc210.filesystem;

// Represents a file
public class File extends FileSystemResource {

    public File(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("File: " + name);
    }
}
