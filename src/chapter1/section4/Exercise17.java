package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise17 {
  public static void main(String[] args) {
    double[] array1 = {-5.2, 9.4, 20, -10, 21.1, 40, 50, -20};
    double[] array2 = {-4, -3, 0, 10, 20};
    double[] array3 = {-10, -3, 0, 2, 4, 20};

    double[] farthestPair1 = farthestPair(array1);
    double[] farthestPair2 = farthestPair(array2);
    double[] farthestPair3 = farthestPair(array3);

    StdOut.println(
        "Farthest pair: " + farthestPair1[0] + " " + farthestPair1[1] + " Expected: -20.0 50.0");
    StdOut.println(
        "Farthest pair: " + farthestPair2[0] + " " + farthestPair2[1] + " Expected: -4.0 20.0");
    StdOut.println(
        "Farthest pair: " + farthestPair3[0] + " " + farthestPair3[1] + " Expected: -10.0 20.0");
  }

  public static double[] farthestPair(double[] a) {
    double[] farthestPair = new double[2];
    double min = a[0];
    double max = a[0];

    for (int i = 0; i < a.length; i++) {
      if (a[i] < min) min = a[i];
      if (a[i] > max) max = a[i];
    }

    farthestPair[0] = min;
    farthestPair[1] = max;
    return farthestPair;
  }
}
