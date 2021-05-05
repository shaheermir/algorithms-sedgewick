package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise28 {
  public static void main(String[] args) {
    int key = 1;
    int[] nums = {1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 9};
    Arrays.sort(nums);

    int[] uniqueNums = removeDuplicatesFromSortedArray(nums);

    StdOut.println(Arrays.toString(uniqueNums));

    //    Exercise22.recursiveBinarySearch(nums, key);
  }

  public static int[] removeDuplicatesFromSortedArray(int[] array) {
    int[] temp = new int[array.length];
    int uniqueCounter = 0;

    for (int i = 0; i < array.length - 1; i++) {
      int current = array[i];
      int next = array[i + 1];
      if (current != next) temp[uniqueCounter++] = current;
    }

    temp[uniqueCounter++] = array[array.length - 1];

    int[] unique = new int[uniqueCounter];
    for (int i = 0; i < unique.length; i++) {
      unique[i] = temp[i];
    }

    return unique;
  }
}
