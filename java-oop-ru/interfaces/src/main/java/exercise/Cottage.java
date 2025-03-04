package exercise;

// BEGIN
import java.util.Locale;
public class Cottage implements Home {

    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public String toString() {
        String formattedNumber = String.format(Locale.US, "%.1f", getArea());
        return String.format("%d этажный коттедж площадью %s метров", floorCount, formattedNumber);
    }

    public double getArea() {
        return area;
    }

    public int compareTo(Home another) {
        if (this.getArea() == another.getArea()) {
            return 0;
        }
        return this.getArea() > another.getArea() ? 1 : -1;
    }
}

// END
