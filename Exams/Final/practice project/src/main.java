import model.Clock;

public class main {
    public static void main(String[] args) {
        for (Integer i: new Clock(2,4)) {
            System.out.println(i);
        }
    }
}
