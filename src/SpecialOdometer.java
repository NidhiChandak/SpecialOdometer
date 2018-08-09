import java.util.ArrayList;

public class SpecialOdometer {
    public ArrayList<Integer> readings;
    public int size;

    public SpecialOdometer(int size) {
        this.size = size;
        readings = new ArrayList<Integer>();
    }

    public int next() {

    }

    public int prev() {

    }

    public int nextNth(int n) {

    }

    public int prevNth(int n) {

    }

    public int difference(SpecialOdometer a) {

    }

    public static void main(String a[]) {
        SpecialOdometer num = new SpecialOdometer(4);

        int result;
        result = num.next();
        System.out.println(result);

        result = num.next();
        System.out.println(result);
    }
}
