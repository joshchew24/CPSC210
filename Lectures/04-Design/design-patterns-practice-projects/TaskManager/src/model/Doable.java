package model;

public abstract class Doable {

    protected Boolean complete = false;
    protected String description;

    public Doable(String description) {
        this.description = description;
    }

    public void complete() {
        complete = true;
    }

    public abstract void display(String indentSpace);


    // getters:

    public String getDescription() {
        return description;
    }

    public Boolean isComplete() {
        return complete;
    }
}
