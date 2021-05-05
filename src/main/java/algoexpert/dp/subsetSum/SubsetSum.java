package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class SubsetSum {

  public static boolean subsetSum(int[] a, int targetSum) {
    return subsetSum(a, targetSum, a.length - 1);
  }

  public static boolean subsetSum(int[] a, int sum, int n) {
    if (n < 0) return false;
    if (sum == 0) return true;

    if (a[n] > sum) return subsetSum(a, sum, n - 1);

    boolean subSetIfIncluded = subsetSum(a, sum - a[n], n - 1);
    boolean subSetIfSkipped = subsetSum(a, sum, n - 1);

    return subSetIfIncluded || subSetIfSkipped;
  }

  public static void main(String[] args) {
    int[] set = {3, 34, 4, 12, 5, 2};
    int sum = 9;

    StdOut.print(subsetSum(set, sum));
  }
}
