package ui;

import model.NoteBook;
import model.TextNote;
import model.WebNote;

public class NotebookApp {
    public static void main(String[] args) {
        NoteBook nb0 = new NoteBook("Second year courses");
        NoteBook nb1 = new NoteBook("Chem");
        NoteBook nb2 = new NoteBook("Math");
        NoteBook nb3 = new NoteBook("Math 200");
        NoteBook nb4 = new NoteBook("Math 221");

        TextNote tn1 = new TextNote("Partial Differentiation");
        TextNote tn2 = new TextNote("The Jacobian");
        TextNote tn3 = new TextNote("Matrix multiplication");
        WebNote wn1 = new WebNote("Helium 3", "https://en.wikipedia.org/wiki/Helium-3");
        WebNote wn2 = new WebNote("Eigenvalues", "https://en.wikipedia.org/wiki/Eigenvalues_and_eigenvectors");

        nb0.addNote(nb1);
        nb0.addNote(nb2);
        nb1.addNote(wn1);
        nb2.addNote(nb3);
        nb2.addNote(nb4);
        nb3.addNote(tn1);
        nb4.addNote(tn2);
        nb4.addNote(tn3);
        nb4.addNote(wn2);

        printNumberOfNotesInNoteBook(nb1);
        printNumberOfNotesInNoteBook(nb2);
        printNumberOfNotesInNoteBook(nb0);
    }

    // EFFECTS: prints number of entries in note book nb, including that note book itself
    private static void printNumberOfNotesInNoteBook(NoteBook nb) {
        System.out.println("There are " + nb.getNumEntries() + " entries in the notebook entitled '"
                + nb.getTitle() + "' (including that notebook itself).");
    }
}
