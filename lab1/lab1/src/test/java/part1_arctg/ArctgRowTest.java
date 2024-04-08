package part1_arctg;

import edu.testing.part1_arctg.ArctgRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;

public class ArctgRowTest {

    private static final double DELTA = 0.0001d;
    private static final int N = 100000;

    protected static String getErrorMessage(double xGiven, double yExpected, double yActual, int n, double delta) {
        return String.format("Arctan from x=%f is not equal to expected %f, but is equal to %f.\n Delta = %f, row members = %d,", xGiven, yExpected, yActual, delta, n);
    }

    @Test
    public void checkArctgAtNegativeInfinity() {
        double x = Double.NEGATIVE_INFINITY;
        final double Y_EXPECTED = - Math.PI / 2;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowVeryLongBeforeMinusOne() {
        double x = -5000452;
        final double Y_EXPECTED = -1.57079613;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowLongBeforeMinusOne() {
        double x = -6489;
        final double Y_EXPECTED = -1.57064222;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowAfterMinusOne() {
        double x = -3.6;
        final double Y_EXPECTED = -1.29984948;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowAtMinusOne() {
        double x = -1;
        final double Y_EXPECTED = - Math.PI / 4;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowBeforeZero() {
        double x = -0.5;
        final double Y_EXPECTED = -0.46364;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgAtZero() {
        double x = 0;
        final double Y_EXPECTED = 0;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgAtMinusZero() {
        double x = -0;
        final double Y_EXPECTED = 0;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowBeforeOne() {
        double x = 0.5;
        final double Y_EXPECTED = 0.46364;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowAtOne() {
        double x = 1;
        final double Y_EXPECTED = Math.PI / 4;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowAfterOne() {
        double x = 3;
        final double Y_EXPECTED = 1.24904577;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowLongAfterOne() {
        double x = 4242;
        final double Y_EXPECTED = 1.57056059;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgRowVeryLongAfterOne() {
        double x = 7000592;
        final double Y_EXPECTED = 1.57079618;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgAtPositiveInfinity() {
        double x = Double.POSITIVE_INFINITY;
        final double Y_EXPECTED = Math.PI / 2;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(result, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }

    @Test
    public void checkArctgSymmetricalSmall() {
        double x1 = Math.random();
        double x2 = -x1;

        double result1 = ArctgRow.getRowElement(x1, N);
        double result2 = ArctgRow.getRowElement(x2, N);
        Assertions.assertEquals(result1, -result2, DELTA, "Function should return symmetrical results.");
    }

    @Test
    public void checkArctgSymmetricalBig() {
        double x1 = Math.random() * 1000000;
        double x2 = -x1;

        double result1 = ArctgRow.getRowElement(x1, N);
        double result2 = ArctgRow.getRowElement(x2, N);
        Assertions.assertEquals(result1, -result2, DELTA, "Function should return symmetrical results.");
    }

    @Test
    public void checkArctgRowAtNaN() {
        double x = NaN;
        final double Y_EXPECTED = NaN;

        double result = ArctgRow.getRowElement(x, N);
        Assertions.assertEquals(x, Y_EXPECTED, DELTA, getErrorMessage(x, Y_EXPECTED, result, N, DELTA));
    }
}
