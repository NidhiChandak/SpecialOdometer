import java.util.ArrayList;

public class SpecialOdometer {
    private static ArrayList<ArrayList<Integer>> readings = new ArrayList<>();

    private int size;
    private int currReading;

    public SpecialOdometer(int size) {
        this.size = size;
        this.generateReadings(this.size);
        this.currReading = readings.get(this.size).get(0);
    }

    public static void initialize() {
        for(int i=0;i<10;i++)
            readings.add(new ArrayList<Integer>());
    }


    public void generateReadings(int size) {
        int[] startReadings = {0, 1, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789};
        int[] endReadings = {0, 9, 89, 789, 6789, 56789, 456789, 3456789, 23456789, 123456789};

        if(readings.get(size).size() == 0) {
            for (int i = startReadings[size]; i <= endReadings[size]; i++) {
                if (checkValidReading(i))
                    readings.get(size).add(i);
            }
        }
    }

    public boolean checkValidReading(int reading) {
        String digits = Integer.toString(reading);
        for(int i=0;i<digits.length()-1;i++) {
            if(digits.charAt(i) >= digits.charAt(i+1))
                return false;
        }
        return true;
    }

    public int findCurrentIndex() {
        return readings.get(this.size).indexOf(this.currReading);
    }

    public int getSize() {
        return readings.get(this.size).size();
    }

    public void next() {
        int currIndex = this.findCurrentIndex() + 1;
        if(currIndex == this.getSize())
            currIndex = 0;
        this.currReading = readings.get(this.size).get(currIndex);
    }

    public void prev() {
        int currIndex = this.findCurrentIndex() - 1;
        if(currIndex == -1)
            currIndex = this.getSize() - 1;
        this.currReading = readings.get(this.size).get(currIndex);
    }

    public void nextNth(int n) {
        for(int i=0;i<n;i++)
            this.next();
    }

    public void prevNth(int n) {
        for(int i=0;i<n;i++)
            this.prev();
    }

    public int difference(SpecialOdometer a) {
        int indexA = this.findCurrentIndex();
        int indexB = a.findCurrentIndex();

        int result = (indexA - indexB + this.getSize()) % this.getSize();
        return result;
    }

    public static void main(String a[]) {
        SpecialOdometer.initialize();
        SpecialOdometer num = new SpecialOdometer(4);

        System.out.println("Current Reading: " + num.currReading);

        num.prev();
        System.out.println("Previous: " + num.currReading);

        num.next();
        System.out.println("Next: " + num.currReading);

        num.nextNth(10);
        System.out.println("Next 10th: " + num.currReading);

        num.prevNth(15);
        System.out.println("Previous 15th: " + num.currReading);

        num.nextNth(10);
        System.out.println("Next 10th: " + num.currReading);

        SpecialOdometer num1 = new SpecialOdometer(4);
        System.out.println("The Difference is: "+num1.difference(num));

        System.out.println("\n" + SpecialOdometer.readings);
    }
}
