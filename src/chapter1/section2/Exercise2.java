package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise2 {
    public static void main(String[] args) {
        int numberOfIntervals = Integer.parseInt(args[0]);

        Interval1D[] intervals = new Interval1D[numberOfIntervals];
        generateIntervals(intervals);
        printIntervalIntersections(intervals);
    }

    private static void generateIntervals(Interval1D[] intervals) {
        final double MIN = 0;
        final double MAX = 10;
        for (int i = 0; i < intervals.length; i++) {
            double firstValue = StdRandom.uniform(MIN, MAX + 1);
            double secondValue = StdRandom.uniform(MIN, MAX + 1);

            if (firstValue > secondValue) {
                double temp = firstValue;
                firstValue = secondValue;
                secondValue = temp;
            }

            intervals[i] = new Interval1D(firstValue, secondValue);
            ;
        }
    }

    private static void printIntervalIntersections(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.printf("Interval 1: Min %.2f  Max %.2f\n", intervals[i].min(), intervals[i].max());
                    StdOut.printf("Interval 2: Min %.2f  Max %.2f\n", intervals[j].min(), intervals[j].max());
                    StdOut.println();
                }
            }
        }
    }
}
