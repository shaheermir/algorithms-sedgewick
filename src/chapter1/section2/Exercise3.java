package chapter1.section2;

import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Exercise3 {
    private static Map<Interval2D, Interval1D[]> intervalMap = new HashMap<>();

    /**
     * @param args - numberOfIntervals minValueForInterval maxValueForInterval
     */
    public static void main(String[] args) {
        int numberOfIntervals = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        Interval2D[] intervals = new Interval2D[numberOfIntervals];
        createAndDrawIntervals(intervals, min, max);

        int[] results = countIntervalIntersectionsAndContains(intervals);
        StdOut.println("Pairs of intervals that intersect: " + results[0]);
        StdOut.println("Intervals contained in one another: " + results[1]);
    }

    private static void createAndDrawIntervals(Interval2D[] intervals, double min, double max) {
        StdDraw.setPenColor();
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.015);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        Color[] colors = new Color[]{Color.BLUE, Color.RED, Color.CYAN, Color.pink, Color.MAGENTA, Color.yellow};
        for (int i = 0; i < intervals.length; i++) {
            Interval1D width = generateInterval1D(min, max);
            Interval1D height = generateInterval1D(min, max);

            Interval2D interval = new Interval2D(width, height);
            intervalMap.put(interval, new Interval1D[]{width, height});
            intervals[i] = interval;

            StdDraw.setPenColor(colors[i % colors.length]);
            interval.draw();
        }
    }

    private static Interval1D generateInterval1D(double min, double max) {
        double firstValue = StdRandom.uniform(min, max);
        double secondValue = StdRandom.uniform(min, max);

        if (firstValue > secondValue) {
            double temp = firstValue;
            firstValue = secondValue;
            secondValue = temp;
        }

        return new Interval1D(firstValue, secondValue);
    }

    private static int[] countIntervalIntersectionsAndContains(Interval2D[] intervals) {

        int[] results = new int[2]; //Intersections and Contains

        int intersections = 0;
        int contains = 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {

                if (intervals[i].intersects(intervals[j])) {
                    intersections++;
                }

                if (contains(intervals[i], intervals[j]) || contains(intervals[j], intervals[i])) {
                    contains++;
                }
            }
        }

        results[0] = intersections;
        results[1] = contains;

        return results;
    }

    private static boolean contains(Interval2D interval1, Interval2D interval2) {
        Interval1D[] intervalsFromInterval1 = intervalMap.get(interval1);
        Interval1D[] intervalsFromInterval2 = intervalMap.get(interval2);

        // Is Interval1 contained within Interval2 ?
        return intervalsFromInterval1[0].min() > intervalsFromInterval2[0].min() &&
                intervalsFromInterval1[0].max() < intervalsFromInterval2[0].max() &&
                intervalsFromInterval1[1].min() > intervalsFromInterval2[1].min() &&
                intervalsFromInterval1[1].max() < intervalsFromInterval2[1].max();
    }
}
