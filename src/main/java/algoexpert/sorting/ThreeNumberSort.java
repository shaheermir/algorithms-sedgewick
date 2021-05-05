package algoexpert.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;

public class ThreeNumberSort {
  public static int[] threeNumberSort(int[] a, int[] order) {
    //    int[] counts = {0, 0, 0};

    HashMap<Integer, Integer> counts = new HashMap<>();
    for (int i : order) counts.put(i, 0);

    for (int i : a) counts.put(i, counts.get(i) + 1);

    int k = 0;
    for (int i = 0; i < order.length; i++) {
      int count = counts.get(order[i]);
      for (int j = 0; j < count; j++) a[k++] = order[i];
    }

    return a;
  }

  public static void main(String[] args) {
    int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
    int[] order = {0, 1, -1};
    int[] expected = {0, 0, 0, 1, 1, 1, -1, -1};
    int[] actual = threeNumberSort(array, order);
    StdOut.println(Arrays.toString(actual));
  }
}
