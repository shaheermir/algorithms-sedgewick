package algoexpert.searching;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Write a function that takes in an array of distinct integers as well as an interger k, and that
 * returns the kth smallest integer in that array.
 *
 * <p>The function should do this in linear time on average.
 */
public class KthSmallestSlower {
  public static int quickselect(int[] array, int k) {
    MaxPQ<Integer> pq = new MaxPQ<>();

    for (int i : array) {
      pq.insert(i);
      if (pq.size() > k) pq.delMax();
    }

    return pq.delMax();
  }

  public static void main(String[] args) {
    int[] a = {8, 5, 2, 9, 7, 6, 3};
    int k = 3;
    int expected = 5;

    StdOut.println(quickselect(a, k) + " Expected " + expected);
  }
}
