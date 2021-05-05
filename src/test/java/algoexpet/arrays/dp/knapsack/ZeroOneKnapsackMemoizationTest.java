package algoexpet.arrays.dp.knapsack;

import algoexpert.dp.knapsack.ZeroOneKnapsackMemoization;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroOneKnapsackMemoizationTest {
  @Test
  void knapsack() {
    int[] w1 = {1, 2, 3};
    int[] v1 = {10, 15, 40};
    int mw1 = 5;

    assertEquals(ZeroOneKnapsackMemoization.knapsack(w1, v1, mw1), 55);

    int[] w2 = {2, 3, 6, 7};
    int[] v2 = {1, 4, 5, 6};
    int mw2 = 10;

    assertEquals(ZeroOneKnapsackMemoization.knapsack(w2, v2, mw2), 10);

    int[] w3 = {2, 3, 6, 7};
    int[] v3 = {99, 4, 5, 6};
    int mw3 = 2;

    assertEquals(ZeroOneKnapsackMemoization.knapsack(w3, v3, mw3), 99);
  }
}
