package ca.ubc.cpsc210.filesystem;

// Represents a file system resource
public abstract class FileSystemResource {
    private static final String TAB = "   ";
    protected String name;

    /**
     * Constructor
     *
     * @param name the name of the file system resource
     */
    public FileSystemResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Prints the tree rooted at this file system resource
     * with indentation that increases at each new level
     * in the tree.
     */
    public void print() {
        print(0);
    }

    /**
     * Prints the tree rooted at this file system resource
     * with given number of levels of indentation.
     *
     * @param indent number of levels of indentation
     *               to be used when printing this file
     *               system resource
     */
    protected abstract void print(int indent);

    /**
     * Prints given number of levels of indentation.
     *
     * @param indent number of levels of indentation to print
     */
    protected void printIndent(int indent) {
        String indentation = "";

        for (int i = 0; i < indent; i++)
            indentation += TAB;

        System.out.print(indentation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileSystemResource that = (FileSystemResource) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
