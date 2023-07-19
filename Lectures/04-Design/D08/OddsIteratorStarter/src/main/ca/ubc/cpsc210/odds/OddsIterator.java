package ca.ubc.cpsc210.odds;

import java.util.Iterator;

/**
 * Iterator for odd integers
 */
public class OddsIterator implements Iterator<Long> {

    private Long next;

    public OddsIterator() {
        next = 1L;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {
        long ans = next;
        next += 2;
        return ans;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("The odds iterator doesn't support remove");
    }
}
