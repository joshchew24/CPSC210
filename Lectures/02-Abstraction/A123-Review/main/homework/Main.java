package homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> los = new ArrayList<String>();
        los.add("A");
        los.add("B");
        los.add("C");
        for (String s : los) {
            System.out.println(s);
        }
    }
}
