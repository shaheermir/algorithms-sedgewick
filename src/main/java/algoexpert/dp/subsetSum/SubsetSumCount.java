package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class SubsetSumCount {

  public static int subsetSumCount(int[] a, int sum) {

    return subsetSumCount(a, sum, a.length - 1, 0);
  }

  private static int subsetSumCount(int[] a, int sum, int n, int count) {
    if (sum == 0) return count + 1;
    if (n < 0) return count;

    int value = a[n];

    if (value > sum) return subsetSumCount(a, sum, n - 1, count);

    int included = subsetSumCount(a, sum - value, n - 1, count);
    int skipped = subsetSumCount(a, sum, n - 1, count);

    return included + skipped;
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 5, 6, 8, 10};
    int targetSum = 10;

    StdOut.println("Array: " + Arrays.toString(a));
    StdOut.println("Target Sum : " + targetSum);
    StdOut.println("Sets that add up to 10: [2, 3, 5]  [2, 8]  [10]");

    StdOut.println("Actual " + subsetSumCount(a, targetSum) + " Expected 3");
  }
}
