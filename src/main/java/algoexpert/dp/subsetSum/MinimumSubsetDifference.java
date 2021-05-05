package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class MinimumSubsetDifference {
  public static int minimumSubsetSumDifference(int[] a) {
    int sumTotal = 0;
    for (int n : a) sumTotal += n;

    return minimizeSubsetSumDifference(a, a.length - 1, 0, sumTotal);
  }

  public static int minimizeSubsetSumDifference(int[] a, int n, int sumCalculated, int sumTotal) {
    if (n < 0) return Math.abs((sumTotal - sumCalculated) - sumCalculated);

    int included = minimizeSubsetSumDifference(a, n - 1, sumCalculated + a[n], sumTotal);
    int skipped = minimizeSubsetSumDifference(a, n - 1, sumCalculated, sumTotal);
    return Math.min(included, skipped);
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 7};
    StdOut.println(minimumSubsetSumDifference(a) + " Expected 4 --> [7] - [1, 2]");

    int[] b = {1, 6, 11, 5};
    StdOut.println(minimumSubsetSumDifference(b) + " Expected 1 --> [1,5,6] - [11]");
  }
}
