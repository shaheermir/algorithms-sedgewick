package algoexpert.searching;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class KthLargestSlower {

  public static int kthLargest(int[] a, int k) {
    MinPQ<Integer> pq = new MinPQ<>();

    for (int i : a) {
      pq.insert(i);
      if (pq.size() > k) pq.delMin();
    }

    return pq.delMin();
  }

  public static void main(String[] args) {
    int[] a = {8, 5, 2, 9, 7, 6, 3};
    int k = 1;
    int expected = 9;

    StdOut.println(kthLargest(a, k) + " Expected " + expected);
  }
}
