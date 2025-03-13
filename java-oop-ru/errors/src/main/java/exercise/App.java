package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle circle) {
        try {
            System.out.println(String.format("%.0f", circle.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.println("�� ������� ��������� �������");
        } finally {
            System.out.println("���������� ��������");
        }
    }
}

// END
