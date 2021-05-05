package algoexpert.dp.unbounded.problems;

import edu.princeton.cs.algs4.StdOut;

public class MinNumberOfCoinsForChange {
  public static int minNumberOfCoinsForChange(int[] coins, int targetChange) {
    if (targetChange == 0) return 0;

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      int coin = coins[i];
      if (coin <= targetChange) {
        int included = minNumberOfCoinsForChange(coins, targetChange - coin);
        if (included != Integer.MAX_VALUE && included + 1 < min) {
          min = included + 1;
        }
      }
    }
    return min;
  }

  public static void main(String[] args) {
    int[] denominations = {1, 5, 10};
    int targetChange = 7;

    StdOut.println(minNumberOfCoinsForChange(denominations, targetChange) + " Expected 3");
  }
}
