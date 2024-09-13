package algoexpert.arrays;

import edu.princeton.cs.algs4.StdOut;
import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Each element in the result should appear as many times as it shows in both arrays. The result can
 * be in any order.
 */
public class Intersection {

  public static int[] intersection(int[] a, int[] b) {
    Map<Integer, Integer> aCount = new HashMap<>();

    for (int i : a) {
      aCount.put(i, aCount.getOrDefault(i, 0) + 1);
    }

    ArrayList<Integer> intersection = new ArrayList<>();

    for (int i : b) {
      if (aCount.getOrDefault(i, 0) > 0) {
        intersection.add(i);
        aCount.put(i, aCount.get(i) - 1);
      }
    }

    int k = 0;
    int[] ans = new int[intersection.size()];
    for (int i : intersection) ans[k++] = i;
    return ans;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 2, 1};
    int[] b = {2, 2};
    int[] expected = {2, 2};

    Queue<Integer> q = new Queue<>();

    StdOut.println(Arrays.toString(intersection(a, b)));
  }
}
