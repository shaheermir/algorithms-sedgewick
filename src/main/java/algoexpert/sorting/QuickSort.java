package algoexpert.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class QuickSort {
  public static int[] quickSort(int[] a) {
    sort(a, 0, a.length - 1);
    return a;
  }

  private static void sort(int[] a, int left, int right) {
    if (left >= right) return;

    int pivotElement = partition(a, left, right);
    sort(a, left, pivotElement - 1);
    sort(a, pivotElement + 1, right);
  }

  private static int partition(int[] a, int left, int right) {
    int pivot = a[left];
    int start = left;
    int end = right;

    while (start < end) {
      while (a[start] <= pivot) {
        if (start == right) break;
        start++;
      }

      while (a[end] >= pivot) {
        if (end == left) break;
        end--;
      }

      if (start < end) swap(a, start, end);
    }

    swap(a, left, end);
    return end;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {

    int[] a = {10, 9, 8, 8, 7, 6, 3, 3, -1, 2, 1};
    quickSort(a);
    StdOut.println(Arrays.toString(a));

    int[] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    quickSort(b);
    StdOut.println(Arrays.toString(b));
  }
}
