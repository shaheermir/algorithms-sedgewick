package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;

public class Exercise8 {
  public static int findNumberOfPairs(int[] nums) {
    Arrays.sort(nums);

    int numberOfPairs = 0;
    int i = 0;

    while (i < nums.length) {
      int number = nums[i];
      int count = 1;
      i++;

      while (i < nums.length && nums[i] == number) {
        count++;
        i++;
      }

      if (count >= 2) {
        numberOfPairs += count / 2;
      }
    }

    return numberOfPairs;
  }

  public static int findNumberOfPairs2(int[] nums) {
    int numberOfPairs = 0;

    HashMap<Integer, Integer> frequencies = new HashMap<>();

    for (int n : nums) {
      int count = 0;
      if (frequencies.containsKey(n)) {
        count = frequencies.get(n);
      }
      count++;
      frequencies.put(n, count);
    }

    for (int n : frequencies.keySet()) {
      int count = frequencies.get(n);
      if (n >= 2) {
        numberOfPairs += count / 2;
      }
    }

    return numberOfPairs;
  }

  public static void main(String[] args) {
    int[] nums = {6, 5, 2, 3, 5, 2, 2, 1};
    StdOut.println(findNumberOfPairs2(nums));
  }
}
