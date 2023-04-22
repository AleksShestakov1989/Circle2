import org.hamcrest.generator.HamcrestFactoryWriter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CircleTest {
    Circle circle = new Circle();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Start all tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Stop all test");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("BeforeEach");
        circle = new Circle();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("AfterEach");
        circle = null;
    }

    @Test
    public void myTestArea() {
        double expected = 50.24, PI = 3.14;
        int radius = 4;
        double result = Circle.calculateCircleArea(PI, radius);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void myTestLength() {
        double expected = 25.12, PI = 3.14;
        int radius = 4;
        double result = Circle.calculateCircleLength(PI, radius);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void myTestAreaDivideLength() {
        System.out.println("Test divide by zero");
        // double expected = 2.5;
        int area = 10, length = 0;
        Class<ArithmeticException> expectedType = ArithmeticException.class;
        Assertions.assertThrows(expectedType, () -> circle.calculateCircleDivideLength(area, length));
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void myTestArea2(double PI, int radius, double expected) {
        double result = Circle.calculateCircleArea(PI, radius);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(3.14, 4, 50.24),
                Arguments.of(3.14, 5, 78.5)
        );
    }
}
