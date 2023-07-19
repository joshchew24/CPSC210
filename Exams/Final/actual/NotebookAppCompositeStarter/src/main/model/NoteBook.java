package model;

import java.util.ArrayList;
import java.util.List;

// Represents a notebook having a title and an arbitrary number of text notes and web notes
public class NoteBook implements Entry {
    private String title;
    private List<Entry> entries;

    // EFFECTS: constructs a notebook with a title and an empty list of text notes
    // and web notes
    public NoteBook(String title) {
        this.title = title;
        entries = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    // MODIFIES: this
    // EFFECTS: adds entry to this notebook
    public void addNote(Entry entry) {
        entries.add(entry);
    }

   @Override
    public int getNumEntries() {
        // starts off as 1 to include itself
        int numEntries = 1;
        for (Entry e : entries) {
            numEntries += e.getNumEntries();
        }
        return numEntries;
    }
}
