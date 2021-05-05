package algoexpert.dp.unbounded.problems;

import edu.princeton.cs.algs4.StdOut;

public class RodCutting {
  // https://practice.geeksforgeeks.org/problems/rod-cutting/0

  public static int rodCutting(int[] prices) {
    int[] lengths = new int[prices.length];
    for (int i = 1; i <= lengths.length; i++) lengths[i - 1] = i;
    return rodCutting(lengths, prices, lengths[lengths.length - 1], lengths.length - 1);
  }

  private static int rodCutting(int[] lengths, int[] prices, int maxLength, int n) {
    if (n < 0 || maxLength == 0) return 0;

    int length = lengths[n];
    int price = prices[n];
    if (length > maxLength) {
      return rodCutting(lengths, prices, maxLength, n - 1);
    }

    int cut = price + rodCutting(lengths, prices, maxLength - length, n);
    int noCut = rodCutting(lengths, prices, maxLength, n - 1);

    return Math.max(cut, noCut);
  }

  public static void main(String[] args) {
    int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
    StdOut.println(rodCutting(prices));
  }
}
