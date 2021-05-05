package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

public class CountNumberOfSubsetsWithGivenDiffBU {

  public static int countNumberOfSubsetsWithGivenDifference(int[] a, int diff) {
    int range = 0;
    for (int n : a) range += n;

    int targetSum = (range + diff) / 2; // s1

    int[][] counts = new int[a.length + 1][targetSum + 1];

    for (int i = 0; i <= a.length; i++) counts[i][0] = 1;

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= targetSum; j++) {
        int capacity = j;
        int value = a[i - 1];

        if (value > capacity) {
          counts[i][j] = counts[i - 1][j];
        } else {
          int included = counts[i - 1][j - value];
          int skipped = counts[i - 1][j];
          counts[i][j] = included + skipped;
        }
      }
    }

    //    print(counts);
    return counts[a.length][targetSum];
  }

  static void print(int[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) System.out.print(grid[r][c] + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 2, 3};
    StdOut.println(countNumberOfSubsetsWithGivenDifference(a, 2));

    StdOut.println(countNumberOfSubsetsWithGivenDifference(new int[] {1, 1, 1, 1, 1}, 3));
  }
}
