package chapter1.section3;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1 {
  public static void main(String[] args) {
    //    int numberOfPoints = Integer.parseInt(args[0]);
    int numberOfPoints = 10;

    Point2D[] points = new Point2D[numberOfPoints];
    createPoints(points);
    drawPoints(points);

    double shortestDistance = findShortestDistance(points);
    StdOut.println(shortestDistance);
  }

  private static void createPoints(Point2D[] points) {
    for (int i = 0; i < points.length; i++) {
      double x = StdRandom.uniform();
      double y = StdRandom.uniform();

      Point2D point = new Point2D(x, y);
      points[i] = point;
    }
  }

  private static void drawPoints(Point2D[] points) {
    StdDraw.setCanvasSize(1024, 512);
    StdDraw.setXscale(0, 1); // unit square
    StdDraw.setYscale(0, 1);
    StdDraw.setPenRadius(0.015);
    for (int i = 0; i < points.length; i++) StdDraw.point(points[i].x(), points[i].y());
  }

  private static double findShortestDistance(Point2D[] points) {
    double shortestDistance = Double.MAX_VALUE;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        double currentDistance = points[i].distanceTo(points[j]);

        if (currentDistance < shortestDistance) shortestDistance = currentDistance;
      }
    }

    return shortestDistance;
  }
}
