package algoexpert.arrays;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  // O( nlog(n) + (n^2)(nlogn)
  // O(1)
  public static List<Integer[]> threeSum(int[] a, int target) {
    Arrays.sort(a);

    ArrayList<Integer[]> triplets = new ArrayList<>();

    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        int twoSum = a[i] + a[j];
        int valueToFind = target - twoSum;

        int index = binarySearch(a, valueToFind);
        if (index > j) triplets.add(new Integer[] {a[i], a[j], a[index]});
      }
    }

    return triplets;
  }

  private static int binarySearch(int[] a, int target) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid] < target) left = mid + 1;
      else if (a[mid] > target) right = mid - 1;
      else return mid;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3};

    List<Integer[]> triplets = threeSum(a, 6);

    for (Integer[] triplet : triplets) {
      StdOut.print(Arrays.toString(triplet) + " ");
    }
  }
}
