package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class MaxSubsetSumNoAdjacentBottomUp {
  public static int maxSubsetSumNoAdjacent(int[] a) {
    if (a.length == 0) return 0;
    if (a.length == 1) return a[0];

    // maximums up to and including (not necessarily) that value at each index.
    int[] maximums = a.clone();
    maximums[1] = Math.max(maximums[0], maximums[1]);

    for (int i = 2; i < a.length; i++) {
      int value = a[i];
      int included = value + maximums[i - 2];
      int skipped = maximums[i - 1];
      maximums[i] = Math.max(included, skipped);
    }

    return maximums[maximums.length - 1];
  }

  public static void main(String[] args) {
    int[] a = {75, 105, 120, 75, 90, 135};

    StdOut.println(maxSubsetSumNoAdjacent(a));
  }
}
