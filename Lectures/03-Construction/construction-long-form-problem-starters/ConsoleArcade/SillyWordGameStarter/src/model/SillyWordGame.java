package model;

import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase> {

    private List<Phrase> phrases;

    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }

    @Override
    public Iterator<Phrase> iterator() {
        return new PhraseIterator();
    }

    private class PhraseIterator implements Iterator<Phrase> {

        @Override
        public boolean hasNext() {
            for (Phrase p : phrases) {
                if (p.needsWord()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Phrase next() {
            for (Phrase p : phrases) {
                if (p.needsWord()) {
                    return p;
                }
            }
            return null;
        }
    }
}
