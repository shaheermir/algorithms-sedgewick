package algoexpert.dp.mcm;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MatrixChainMultiplicationMemo {

  public static int mcm(int[] a) {
    int[][] cache = new int[a.length][a.length];
    for (int i = 0; i < cache.length; i++) Arrays.fill(cache[i], -1);

    return mcm(a, 1, a.length - 1, cache);
  }

  private static int mcm(int[] a, int i, int j, int[][] cache) {
    if (i == j) return 0;

    if (cache[i][j] != -1) return cache[i][j];

    int min = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int leftCount = mcm(a, i, k, cache);
      int rightCount = mcm(a, k + 1, j, cache);
      int costToMultiplyLeftAndRight = (a[i - 1] * a[k] * a[j]);
      int count = leftCount + costToMultiplyLeftAndRight + rightCount;

      if (count < min) min = count;
    }

    return cache[i][j] = min;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 3};
    StdOut.println("Minimum Number of Multiplications is: " + mcm(a));
  }
}
