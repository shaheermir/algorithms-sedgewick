package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class SubsetSumMemoization {
  public static boolean subsetSum(int[] a, int targetSum) {
    int[][] cache = new int[a.length][targetSum + 1];
    for (int i = 0; i < cache.length; i++)
      for (int j = 0; j < cache[0].length; j++) cache[i][j] = -1;

    int result = subsetSum(a, targetSum, a.length - 1, cache);
    return result == 1;
  }

  public static int subsetSum(int[] a, int sum, int n, int[][] cache) {
    if (n < 0) return 0;
    if (sum == 0) return 1;

    if (cache[n][sum] != -1) return cache[n][sum];

    if (a[n] > sum) return cache[n][sum] = subsetSum(a, sum, n - 1, cache);

    int subSetIfIncluded = subsetSum(a, sum - a[n], n - 1, cache);
    int subSetIfSkipped = subsetSum(a, sum, n - 1, cache);

    return cache[n][sum] = subSetIfIncluded == 1 || subSetIfSkipped == 1 ? 1 : 0;
  }

  public static void main(String[] args) {
    int[] set = {3, 34, 4, 12, 5, 2};
    int sum = 10;

    StdOut.print(subsetSum(set, sum));
  }
}
