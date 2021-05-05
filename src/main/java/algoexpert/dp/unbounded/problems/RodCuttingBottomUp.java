package algoexpert.dp.unbounded.problems;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class RodCuttingBottomUp {
  public static int rodCutting(int[] prices) {
    int[] lengths = new int[prices.length];
    for (int i = 1; i <= lengths.length; i++) lengths[i - 1] = i;
    StdOut.println(Arrays.toString(lengths));
    int maxLength = lengths[lengths.length - 1];

    int[][] profits = new int[prices.length + 1][maxLength + 1];

    for (int i = 1; i <= prices.length; i++) {
      for (int j = 1; j <= maxLength; j++) {

        int length = lengths[i - 1];
        int price = prices[i - 1];

        if (length > j) {
          profits[i][j] = profits[i - 1][j];
        } else {
          int cut = price + profits[i][j - length];
          int noCut = profits[i - 1][j];
          profits[i][j] = Math.max(cut, noCut);
        }
      }
    }

    return profits[profits.length - 1][profits[0].length - 1];
  }

  public static void main(String[] args) {
    int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
    StdOut.println(rodCutting(prices));
  }
}
