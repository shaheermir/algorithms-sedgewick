package algoexpert.searching;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class findThreeLargestNumbers {

  public static int[] findThreeLargestNumbers(int[] a) {
    int[] threelargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

    return threelargest;
  }

  public static void main(String[] args) {
    int[] a = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
    StdOut.println(Arrays.toString(findThreeLargestNumbers(a)));
  }
}
