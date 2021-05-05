package algoexpert.arrays;

import edu.princeton.cs.algs4.StdOut;

// TODO
public class LongestPeak {
  public static int longestPeak(int[] a) {
    int max = 0;
    int temp = 0;

    boolean increasing = a[0] < a[1];
    boolean decreasing = !increasing;
    boolean peaked = false;

    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] > a[i + 1]) {

        if (decreasing) {
          temp = 0;
        } else temp++;

        increasing = true;
        decreasing = false;
      } else if (a[i] < a[i + 1]) {
        if (increasing) {
          peaked = true;
          decreasing = true;
        }
        if (peaked && decreasing) temp++;
      }

      if (temp > max) max = temp;
    }

    return max;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
    StdOut.println(longestPeak(a));
  }
}
