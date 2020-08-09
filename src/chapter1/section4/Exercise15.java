package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;

public class Exercise15 {
  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, 2, 4, 5, 6, 6};
    StdOut.println(Arrays.toString(twoSum(nums, 8)));

    StdOut.println("8: " + twoSumCount2(nums, 8));
    StdOut.println("4: " + twoSumCount2(nums, 4));
  }

  // O(N)
  public static int[] twoSum(int[] a, int target) {
    Arrays.sort(a);
    int i = 0;
    int j = a.length - 1;
    int[] indices = {-1, -1};

    while (i < j) {
      int sum = a[i] + a[j];
      if (sum == target) {
        indices[0] = i;
        indices[1] = j;
        return indices;
      }
      if (sum < target) i++;
      if (sum > target) j--;
    }

    return indices;
  }

  // Finds distinct pairs, as in it fails for duplicate / repeating elements.
  public static int twoSumCount(int[] a, int target) {
    Arrays.sort(a);
    int count = 0;
    int i = 0;
    int j = a.length - 1;

    while (i < j) {
      int sum = a[i] + a[j];
      if (sum == target) {
        count++;
        i++;
        j--;
      }
      if (sum < target) i++;
      if (sum > target) j--;
    }
    return count;
  }

  static int twoSumCount2(int[] a, int sum) {

    int count = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < a.length; i++) {
      if (!hm.containsKey(a[i])) hm.put(a[i], 0);
      hm.put(a[i], hm.get(a[i]) + 1);
    }

    for (int i = 0; i < a.length; i++) {
      int complement = sum - a[i];
      if (hm.get(complement) != null) {
        count = count + hm.get(complement);
      }

      if (complement == a[i]) count--;
    }

    return count / 2;
  }
}
