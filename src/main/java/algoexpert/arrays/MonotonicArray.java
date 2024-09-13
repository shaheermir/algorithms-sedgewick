package algoexpert.arrays;

import edu.princeton.cs.algs4.StdOut;

public class MonotonicArray {
  public static boolean isMonotonic(int[] a) {

    boolean patternSet = false;
    boolean isIncreasing = false;

    for (int i = 0; i < a.length - 1; i++) {
      if (!patternSet) {
        if (a[i] == a[i + 1]) continue;
        else if (a[i] < a[i + 1]) isIncreasing = true;
        else if (a[i] > a[i + 1]) isIncreasing = false;
        patternSet = true;
      }

      if (patternSet) {
        if (a[i] < a[i + 1] && !isIncreasing) return false;
        if (a[i] > a[i + 1] && isIncreasing) return false;
      }
    }

    return true;
  }

  public static boolean isMonotonic2(int[] a) {
    if (a.length <= 2) return true;

    int direction = a[1] - a[0];

    for (int i = 1; i < a.length - 1; i++) {
      if (direction == 0) {
        direction = a[i + 1] - a[i];
        continue;
      }

      if (a[i] < a[i + 1] && direction < 0) return false;
      if (a[i] > a[i + 1] && direction > 0) return false;
    }

    return true;
  }

  public static boolean isMonotonic3(int[] a) {
    int k = a.length - 1;
    int direction = a[k] - a[0];

    while (direction == 0) {
      k--;
      direction = a[k] - a[0];
    }

    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] < a[i + 1] && direction < 0) return false;
      if (a[i] > a[i + 1] && direction > 0) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    StdOut.println(isMonotonic(new int[] {1, 2, 3, 4, 5, 5, 5, 6, 7}));
    StdOut.println(isMonotonic(new int[] {1, 2, 3, 4, 5, 5, 5, 6, 1}));
  }
}
