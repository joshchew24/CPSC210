package model;

import java.util.Iterator;

public class Clock implements Iterable<Integer> {
    private Integer startTime;
    private Integer numHours;

    public Clock(Integer start, Integer hrs ) {
        startTime = start;
        numHours = hrs;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ClockIterator();
    }

    private class ClockIterator implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return numHours != 0;
        }

        @Override
        public Integer next() {
            numHours--;
            return startTime++;
        }
    }
}