package observer;

import model.NoteBook;
import model.TextNote;
import model.WebNote;

public class ConsoleWriter implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        NoteBook notebook = (NoteBook) observable;
        String noteType = null;
        if (arg instanceof TextNote) {
            noteType = "text note";
        } else if (arg instanceof WebNote) {
            noteType = "web note";
        }
        System.out.println("A " + noteType + " has been added to the " + notebook.getTitle() + " notebook.");
    }
}
