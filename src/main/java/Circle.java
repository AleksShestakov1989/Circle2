import java.util.ArrayList;
import java.util.List;

public class Circle {

    public static void main(String[] args) {

        double area = calculateCircleArea(3.14, 4);
        double length = calculateCircleLength(3.14, 4);
        List<Double> list = List.of(area, length);
        System.out.println("Радиус = 4 см.");
        System.out.println("Площадь круга: " + area + " см.кв.");
        System.out.println("Длина окружности: " + length + " см.");
    }

    public static double calculateCircleArea(double PI, int radius) {
        return PI * radius * radius;
    }

    public static double calculateCircleLength(double PI, int radius) {
        return 2 * PI * radius;
    }

    public double calculateCircleDivideLength(int area, int length) {
        return area / length;
    }
}
