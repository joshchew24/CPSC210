package model;

import java.util.ArrayList;
import java.util.List;

// Represents a text note having a title and an arbitrary number of lines of text
public class TextNote {
    private List<String> lines;
    private String title;

    // EFFECTS: constructs a text note with a title and no lines of text
    public TextNote(String title) {
        this.title = title;
        lines = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds line to end of this text note
    public void addLineToNote(String line) {
        lines.add(line);
    }

    // MODIFIES: this
    // EFFECTS: removes line at index (first line in note is
    // at index 0)
    public void removeLineAt(int index) {
        lines.remove(index);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getLines() {
        return lines;
    }
}
