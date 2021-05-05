package algoexpert.dp.mcm;

import edu.princeton.cs.algs4.StdOut;

/**
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
 * The problem is not actually to perform the multiplications, but merely to decide in which order
 * to perform the multiplications.
 */
public class MatrixChainMultiplication {
  static int c;

  public static int mcm(int[] a) {
    return mcm(a, 1, a.length - 1);
  }

  private static int mcm(int[] a, int i, int j) {
    if (i == j) return 0;

    int min = Integer.MAX_VALUE;

    c++;
    for (int k = i; k < j; k++) {
      int leftCount = mcm(a, i, k);
      int rightCount = mcm(a, k + 1, j);
      int costToMultiplyLeftAndRight = (a[i - 1] * a[k] * a[j]);
      int count = leftCount + costToMultiplyLeftAndRight + rightCount;

      if (count < min) min = count;
    }

    return min;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 3};
    StdOut.println("Minimum Number of Multiplications is: " + mcm(a));
    StdOut.println(c);
  }
}
