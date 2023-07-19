package model;

import observer.Observable;

import java.util.ArrayList;
import java.util.List;

// Represents a notebook having a title and an arbitrary number of text notes and web notes
public class NoteBook extends Observable {
    private String title;
    private List<TextNote> textNotes;
    private List<WebNote> webNotes;

    // EFFECTS: constructs a notebook with a title and an empty list of text notes
    // and web notes
    public NoteBook(String title) {
        this.title = title;
        textNotes = new ArrayList<>();
        webNotes = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    // MODIFIES: this
    // EFFECTS: adds textNote to this notebook
    public void addNote(TextNote textNote) {
        textNotes.add(textNote);
        notifyObservers(this, textNote);
    }

    // MODIFIES: this
    // EFFECTS: adds webNote to this notebook
    public void addNote(WebNote webNote) {
        webNotes.add(webNote);
        notifyObservers(this, webNote);
    }
}
