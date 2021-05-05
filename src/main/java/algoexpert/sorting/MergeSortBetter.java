package algoexpert.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MergeSortBetter {
  public static int[] mergeSort(int[] a) {
    int[] aux = new int[a.length];
    sort(a, aux, 0, a.length - 1);
    return a;
  }

  private static void sort(int[] a, int[] aux, int left, int right) {
    if (left >= right) return;

    int mid = (left + right) / 2;
    sort(a, aux, left, mid);
    sort(a, aux, mid + 1, right);
    merge(a, aux, left, mid, right);
  }

  private static void merge(int[] a, int[] aux, int left, int mid, int right) {
    for (int i = left; i <= right; i++) aux[i] = a[i];
    int leftIndex = left;
    int rightIndex = mid + 1;
    int arrayIndex = left;

    while (leftIndex <= mid && rightIndex <= right) {
      if (aux[leftIndex] < aux[rightIndex]) a[arrayIndex++] = aux[leftIndex++];
      else a[arrayIndex++] = aux[rightIndex++];
    }

    while (leftIndex <= mid) {
      a[arrayIndex++] = aux[leftIndex++];
    }

    while (rightIndex <= right) {
      a[arrayIndex++] = aux[rightIndex++];
    }
  }

  public static void main(String[] args) {
    int[] a = {10, 9, 8, 8, 7, 6, 3, 3, -1, 2, 1};
    StdOut.println(Arrays.toString(mergeSort(a)));

    int[] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    StdOut.println(Arrays.toString(mergeSort(b)));
  }
}
