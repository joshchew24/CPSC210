package ui;

import model.NoteBook;
import model.TextNote;
import model.WebNote;
import observer.ConsoleWriter;

public class NotebookApp {
    public static void main(String[] args) {
        NoteBook chem = new NoteBook("Chem");
        NoteBook m200 = new NoteBook("Math 200");
        NoteBook m221 = new NoteBook("Math 221");

        TextNote tn1 = new TextNote("Partial Differentiation");
        TextNote tn2 = new TextNote("The Jacobian");
        TextNote tn3 = new TextNote("Matrix multiplication");
        WebNote wn1 = new WebNote("Helium 3", "https://en.wikipedia.org/wiki/Helium-3");
        WebNote wn2 = new WebNote("Eigenvalues", "https://en.wikipedia.org/wiki/Eigenvalues_and_eigenvectors");

        ConsoleWriter consoleWriter = new ConsoleWriter();
        chem.addObserver(consoleWriter);
        m200.addObserver(consoleWriter);
        m221.addObserver(consoleWriter);

        chem.addNote(wn1);
        m200.addNote(tn1);
        m221.addNote(tn2);
        m221.addNote(tn3);
        m221.addNote(wn2);
    }

}
