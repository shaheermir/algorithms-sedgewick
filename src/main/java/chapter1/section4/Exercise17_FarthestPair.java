package chapter1.section4;

public class Exercise17_FarthestPair {

  /**
   * Finds two numbers that have the greatest difference. Those two would ofcourse be the min and
   * max. Max - Min will give us the biggest diff. O(N) - Just loop through array, keeping track of
   * min and max.
   */
  public static double[] farthestPair(double[] a) {
    double[] pair = new double[2];

    double min = Double.MAX_VALUE;
    double max = Double.MIN_VALUE;

    for (int i = 0; i < a.length; i++) {
      if (a[i] < min) min = a[i];
      if (a[i] > max) max = a[i];
    }

    return pair;
  }
}
