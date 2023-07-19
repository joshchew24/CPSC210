package ui;

import model.IntegerSet;

// simple application illustrating use of the IntegerSet class
public class Main {
  public static void main(String[] args) {
  IntegerSet setA = new IntegerSet();
  IntegerSet setB = new IntegerSet();

  setA.insert(1);
  setA.insert(52);
  setA.insert(24);
  setA.insert(169);

  setB.insert(2);
  setB.insert(53);
  setB.insert(24);
  setB.insert(169);

  setA.intersection(setB);
  }
}
