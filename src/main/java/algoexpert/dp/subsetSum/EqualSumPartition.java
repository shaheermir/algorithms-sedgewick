package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class EqualSumPartition {
  /**
   * Given an array a, this function finds if its possible to partition it into two subsets such
   * that their sums are equal.
   *
   * @param a - array to partition
   */
  public static boolean equalSumPartition(int[] a) {
    int totalSumArray = 0;
    for (int i = 0; i < a.length; i++) totalSumArray += a[i];

    boolean sumIsEven = totalSumArray % 2 == 0;

    if (!sumIsEven) return false;

    return subsetSum(a, totalSumArray / 2, a.length - 1);
  }

  private static boolean subsetSum(int[] a, int sum, int n) {
    if (n < 0) return false;
    if (sum == 0) return true;

    int value = a[n];
    if (value > sum) return subsetSum(a, sum, n - 1);

    boolean included = subsetSum(a, sum - value, n - 1);
    boolean skipped = subsetSum(a, sum, n - 1);

    return included || skipped;
  }

  public static void main(String[] args) {
    int[] a = {1, 5, 11, 6};
    StdOut.println(equalSumPartition(a));
  }
}
