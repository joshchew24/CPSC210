package ui;

import model.IntegerSet;

// simple application illustrating use of the IntegerSet class
public class Main {
  public static void main(String[] args) {
      IntegerSet setA = new IntegerSet();
      IntegerSet setB = new IntegerSet();

      setA.insert(1);
      setA.insert(3);
      setA.insert(5);
      setA.insert(7);
      setA.insert(9);

      setB.insert(3);
      setB.insert(6);
      setB.insert(9);

      IntegerSet intersectAB = setA.intersection(setB);
      intersectAB.print();
  }
}
