package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class MaxSubsetSumNoAdjacent {

  public static int maxSubsetSumNoAdjacent(int[] a) {

    return maxSubsetSumNoAdjacent(a, a.length - 1);
  }

  public static int maxSubsetSumNoAdjacent(int[] a, int n) {
    if (n < 0) return 0;

    int value = a[n];
    int included = value + maxSubsetSumNoAdjacent(a, n - 2);
    int skipped = maxSubsetSumNoAdjacent(a, n - 1);

    return Math.max(included, skipped);
  }

  public static void main(String[] args) {
    int[] a = {75, 105, 120, 75, 90, 135};
    // maximize sum of non adjacent entries

    StdOut.println(maxSubsetSumNoAdjacent(a));
  }
}
