package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;

public class Exercise15_1_TwoSumFaster {

  // O(N) after the array is sorted.
  // needs improvement to handle multiple pairings of the same element.
  // the logic for 0s could use some work as well.
  public static int twoSumFaster(int[] a) {
    Arrays.sort(a);
    int count = 0;

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int sum = a[left] + a[right];

      if (sum < 0) left++;
      else if (sum > 0) right--;
      else {
        left++;
        right--;
        if (a[left] == 0 && a[right] == 0) continue;
        count++;
      }
    }

    return count;
  }

  // O(N) - no sorting required.
  public static int twoSumEvenFaster(int[] a) {
    int count = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < a.length; i++) {
      if (!hm.containsKey(a[i])) hm.put(a[i], 1);
      else hm.put(a[i], hm.get(a[i]) + 1);
    }

    for (int i = 0; i < a.length; i++) {
      int complement = -a[i];

      if (hm.get(complement) != null) {
        count = count + hm.get(complement);
      }

      if (a[i] == complement) count--;
    }

    return count / 2;
  }

  public static void main(String[] args) {
    int[] nums = {-6, -1, 0, 1, 2, 2, 4, 5, 6, 6};
    StdOut.println(twoSumFaster(nums));

    StdOut.println(twoSumEvenFaster(nums));
  }
}
