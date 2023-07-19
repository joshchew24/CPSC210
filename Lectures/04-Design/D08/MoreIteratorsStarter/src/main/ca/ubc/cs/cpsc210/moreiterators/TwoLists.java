package ca.ubc.cs.cpsc210.moreiterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * A collection-like class that stores its data in two separate lists
 * <p>
 * Iterating over the data could return the data in a number of different ways:
 * 1) OneThenTwo:  all the data from listone followed by all the data from listtwo
 * 2) Alternating: the data from listone and listtwo alternating (one from listone, then
 * one from listtwo, then one from listone, ...). When one list runs out, then
 * return the rest of the data from the other list until it too runs out
 * 3) Cartesian: the data from the two lists combined (cartesian product style) by multiplying.
 * If there are four items in listone, named l11, l12, l13, l14 and three items
 * in listtwo named l21, l22, l23, then these elements would be returned:
 * l11 * l21, l11 * l22, l11 * l23,
 * l12 * l21, l12 * l22, l12 * l23,
 * l13 * l21, l13 * l22, l13 * l23,
 * l14 * l21, l14 * l22, l14 * l23,
 * A client can choose which iterator is returned by calling the chooseIterator() method before calling
 * iterator().
 */
public class TwoLists implements Iterable<Integer> {
    public static final int ONE_THEN_TWO = 0;
    public static final int ALTERNATING = 1;
    public static final int CARTESIAN = 2;
    private List<Integer> listone;
    private List<Integer> listtwo;
    private int whichIterator = -1;

    public TwoLists() {
        listone = new ArrayList<Integer>();
        listtwo = new ArrayList<Integer>();
    }

    // MODIFIES: this
    // EFFECTS: Sets the iterator that will be returned when iterator() is called. If no iterator
    // has been chosen, then return a random iterator.
    public void chooseIterator(int whichIterator) {
        this.whichIterator = whichIterator;
    }

    // MODIFIES: this
    // EFFECTS: adds value to list one if which is 1, and to list two if which is 2;
    // throws a RuntimeException if which is neither 1 nor 2
    public void add(int which, Integer value) {
        switch (which) {
            case 1:
                listone.add(value);
                break;
            case 2:
                listtwo.add(value);
                break;
            default:
                throw new RuntimeException("TwoLists.add with illegal which argument " + which);
        }
    }

    @Override
    public Iterator iterator() {
        if (whichIterator == -1) {
            whichIterator = new Random().nextInt(3);
        }
        switch (whichIterator) {
            case ONE_THEN_TWO:
                return new OneThenTwoIterator();
            case ALTERNATING:
                return new AlternatingIterator();
            default:
                return new CartesianIterator();
        }
    }

    private class OneThenTwoIterator implements Iterator {
        private Iterator<Integer> listOneIterator;
        private Iterator<Integer> listTwoIterator;

        OneThenTwoIterator() {
            listOneIterator = listone.iterator();
            listTwoIterator = listtwo.iterator();
        }

        @Override
        public boolean hasNext() {
            return listOneIterator.hasNext() || listTwoIterator.hasNext();
        }

        @Override
        public Object next() {
            return listOneIterator.hasNext() ? listOneIterator.next() : listTwoIterator.next();
        }
    }

    private class AlternatingIterator implements Iterator {
        private Iterator<Integer> listOneIterator;
        private Iterator<Integer> listTwoIterator;
        private Boolean currentListIsOne;

        AlternatingIterator() {
            listOneIterator = listone.iterator();
            listTwoIterator = listtwo.iterator();
            currentListIsOne = true;
        }


        @Override
        public boolean hasNext() {
            return listOneIterator.hasNext() || listTwoIterator.hasNext();
        }

        @Override
        public Object next() {
            if ((currentListIsOne && listOneIterator.hasNext()) || !listTwoIterator.hasNext()) {
                currentListIsOne = false;
                return listOneIterator.next();
            } else {
                currentListIsOne = true;
                return listTwoIterator.next();
            }
        }
    }

    private class CartesianIterator implements Iterator {
        private Iterator<Integer> listOneIterator;
        private Iterator<Integer> listTwoIterator;

        private Integer one;

        CartesianIterator() {
            listOneIterator = listone.iterator();
            listTwoIterator = listtwo.iterator();
            one = listOneIterator.hasNext() ? listOneIterator.next() : null;
        }

        @Override
        public boolean hasNext() {
            return one != null && listTwoIterator.hasNext();
        }

        @Override
        public Object next() {
            int ans = one * listTwoIterator.next();

            if (!listTwoIterator.hasNext() && listOneIterator.hasNext())  {
                one = listOneIterator.next();
                listTwoIterator = listtwo.iterator();
            }

            return ans;
        }
    }
}
