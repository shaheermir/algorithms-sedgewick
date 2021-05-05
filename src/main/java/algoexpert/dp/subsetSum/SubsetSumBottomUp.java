package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class SubsetSumBottomUp {

  public static boolean subsetSum(int[] a, int targetSum) {
    boolean[][] result = new boolean[a.length + 1][targetSum + 1];
    for (int i = 0; i < a.length + 1; i++) result[i][0] = true;

    for (int i = 1; i < a.length + 1; i++) {
      for (int j = 1; j < targetSum + 1; j++) {
        int value = a[i - 1];
        int sum = j;

        if (value > sum) {
          result[i][j] = result[i - 1][j];
        } else {
          boolean ifIncluded = result[i - 1][j - value];
          boolean ifSkipped = result[i - 1][j];
          result[i][j] = ifIncluded || ifSkipped;
        }
      }
    }
    //    print(result);
    return result[a.length][targetSum];
  }

  static void print(boolean[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        String b = grid[r][c] ? "t" : "f";
        System.out.print(b + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] set = {3, 4, 5, 2};
    int targetSum = 6;

    StdOut.print(subsetSum(set, targetSum));
  }
}
