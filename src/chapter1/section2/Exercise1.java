package chapter1.section2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1 {
    public static void main(String[] args) {
        int numberOfPoints = Integer.parseInt(args[0]);

        Point2D[] points = new Point2D[numberOfPoints];
        createPoints(points);

        double shortestDistance = calculateShortedDistance(points);
        StdOut.printf("The distance separating the closest pair of points is %.2f", shortestDistance);
    }

    public static void createPoints(Point2D[] points) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setXscale(0, 1); // unit square
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(0.015);

        for (int i = 0; i < points.length; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();

            Point2D point = new Point2D(x, y);
            StdDraw.point(point.x(), point.y());
            points[i] = point;
        }
    }

    public static double calculateShortedDistance(Point2D[] points) {
        double shortestDistance = Double.MAX_VALUE;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double currentDistance = points[i].distanceTo(points[j]);
                if (currentDistance < shortestDistance)
                    shortestDistance = currentDistance;
            }
        }
        return shortestDistance;
    }
}
