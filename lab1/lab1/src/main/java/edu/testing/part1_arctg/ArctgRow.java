package edu.testing.part1_arctg;

import static java.lang.Math.*;

public class ArctgRow {

    /** Function returns result of function arctg(X) with the given X.
     Max value = Pi/2, min value = -Pi/2

     @param x value of X
     @param n amount of row elements
     */
    public static double getRowElement(double x, int n) {
        double sum = 0d;
        if (abs(x) <= 1) {
            for (int i = 0; i <= n; i++) {
                sum += pow(-1, i) * (pow(x, 2 * i + 1) / (2 * i + 1));
            }
        }
        else {
            double f1 = PI * signum(x) / 2;
            double f2 = 0d;
            for (int i = 0; i <= n; i++) {
                f2 += pow(-1, i) * pow(x, -1 - 2 * i) / (1 + 2 * i);
            }
            sum += f1 - f2;
        }

        return sum;
    }
}
