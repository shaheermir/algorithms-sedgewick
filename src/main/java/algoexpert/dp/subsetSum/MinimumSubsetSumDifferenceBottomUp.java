package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class MinimumSubsetSumDifferenceBottomUp {
  /**
   * Partition the subset into 2 subsets such that the difference of the sum of those subsets is
   * minimized. Theres a lot of thinking and logic that has gone into this soln. the 10 lines of
   * code doesnt do it justice. Make sure to read up / watch Adtiyas video.
   *
   * @param a
   * @return
   */
  public static int minimumSubsetSumDifference(int[] a) {
    int range = 0;
    for (int n : a) range += n;

    int cols = (range + 1) / 2;
    boolean[][] sums = new boolean[a.length + 1][cols];
    for (int i = 0; i <= a.length; i++) sums[i][0] = true;

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j < cols; j++) {

        int value = a[i - 1];
        int capacity = j;

        if (value > capacity) {
          sums[i][j] = sums[i - 1][j];
        } else {
          boolean included = sums[i - 1][j - value];
          boolean skipped = sums[i - 1][j];
          sums[i][j] = included || skipped;
        }
      }
    }

    int sum1 = 0;
    for (int i = sums[0].length - 1; i >= 0; i--) {
      if (sums[sums.length - 1][i]) {
        sum1 = i;
        break;
      }
    }

    int minimumDifference = range - (2 * sum1);
    return minimumDifference;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 7};
    StdOut.println(minimumSubsetSumDifference(a) + " Expected 4 --> [7] - [1, 2]");

    int[] b = {1, 6, 11, 5};
    StdOut.println(minimumSubsetSumDifference(b) + " Expected 1 --> [1,5,6] - [11]");
  }
}
