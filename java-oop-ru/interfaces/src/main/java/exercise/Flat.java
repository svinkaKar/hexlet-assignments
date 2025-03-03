package exercise;

// BEGIN
public class Flat implements Home {

    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area + balconyArea;
    }

    public String toString() {
        String formattedNumber = String.format(Locale.US, "%.1f", getArea());
        return String.format(" вартира площадью %s метров на %d этаже", formattedNumber, floor);
    }

    public int compareTo(Home another) {
        if (this.getArea() == another.getArea()){
            return 0;
        }
        return this.getArea() > another.getArea() ? 1 : -1;
    }
}

// END
