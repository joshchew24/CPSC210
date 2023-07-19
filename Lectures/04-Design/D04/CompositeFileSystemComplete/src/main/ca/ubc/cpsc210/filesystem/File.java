package ca.ubc.cpsc210.filesystem;

// Represents a file
public class File extends FileSystemResource {

    public File(String name) {
        super(name);
    }

    @Override
    protected void print(int indent) {
        printIndent(indent);
        System.out.println("File: " + this.name);
    }
}
