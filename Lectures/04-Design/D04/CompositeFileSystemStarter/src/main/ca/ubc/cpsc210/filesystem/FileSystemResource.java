package ca.ubc.cpsc210.filesystem;

import java.util.Objects;

// Represents a file system resource
public abstract class FileSystemResource {
	protected String name;

	public FileSystemResource(String name) {
	    this.name = name;
    }
	
	public String getName() {
		return name;
	}

    /**
     * Prints the tree rooted at this file system resource.
     */
	public abstract void print();

	public void print(int indent) {
	    for (int i = 1; i <= indent; i++) {
            System.out.print("\t");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileSystemResource that = (FileSystemResource) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
