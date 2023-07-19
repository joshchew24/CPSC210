package model;

import java.util.ArrayList;
import java.util.List;

// Represents a set of integers
public class IntegerSet {
  private List<Integer> data;

  // EFFECTS: set is empty
  public IntegerSet() {
    data = new ArrayList<>();
  }

  // MODIFIES: this
  // EFFECTS: Integer i is added to the IntegerSet if it's not
  // already in the IntegerSet
  public void insert(Integer i) {
    if (!contains(i))
      data.add(i);
  }

  // REQUIRES: Integer i is an element of the IntegerSet
  // MODIFIES: this
  // EFFECTS: Integer i is removed from the IntegerSet
  public void remove(Integer i) {
    data.remove(i);
  }

  // EFFECTS: Returns true if Integer i is in the IntegerSet
  // and false otherwise
  public boolean contains(Integer i) {
    return data.contains(i);
  }

  // EFFECTS: Returns the number of items in the set
  public int size() {
    return data.size();
  }

  // EFFECTS: Returns the intersection of this and other
  public IntegerSet intersection(IntegerSet other){
      IntegerSet intersection = new IntegerSet();
    for (Integer i : data){
        if (other.contains(i)){
            intersection.insert(i);
        }
    }
    return intersection;
  }

  public void print(){
      for (Integer i : data){
          System.out.println(i);
      }
  }


}
