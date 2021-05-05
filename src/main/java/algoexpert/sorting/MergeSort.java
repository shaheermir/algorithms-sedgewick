package algoexpert.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MergeSort {
  public static int[] mergeSort(int[] a) {
    if (a.length <= 1) return a;

    int mid = a.length / 2;
    int[] leftHalf = Arrays.copyOfRange(a, 0, mid);
    int[] rightHalf = Arrays.copyOfRange(a, mid, a.length);

    int[] leftSorted = mergeSort(leftHalf);
    int[] rightSorted = mergeSort(rightHalf);
    return merge(leftSorted, rightSorted);
  }

  private static int[] merge(int[] left, int[] right) {
    int[] merged = new int[left.length + right.length];

    int k = 0;
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < left.length && rightIndex < right.length) {
      if (left[leftIndex] < right[rightIndex]) merged[k++] = left[leftIndex++];
      else merged[k++] = right[rightIndex++];
    }

    while (leftIndex < left.length) {
      merged[k++] = left[leftIndex++];
    }

    while (rightIndex < right.length) {
      merged[k++] = right[rightIndex++];
    }

    return merged;
  }

  public static void main(String[] args) {
    int[] a = {10, 9, 8, 8, 7, 6, 3, 3, -1, 2, 1};
    StdOut.println(Arrays.toString(mergeSort(a)));

    int[] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    StdOut.println(Arrays.toString(mergeSort(b)));
  }
}
