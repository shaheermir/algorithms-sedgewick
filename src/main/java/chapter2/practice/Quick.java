package chapter2.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Quick {
  public static void sort(int[] a) {
    //    StdRandom.shuffle(a);
    quickSort(a, 0, a.length - 1);
  }

  private static void quickSort(int[] a, int low, int high) {
    if (low >= high) return;

    int pivotIndex = partition(a, low, high);

    quickSort(a, low, pivotIndex - 1);
    quickSort(a, pivotIndex + 1, high);
  }

  // Jenny's Lectures has a good guide on this but shes missing 1 small thing.
  // keep incrementing start as long as a[start] <= pivot, but we also have to ensure, we dont go
  // over the high limit
  private static int partition(int[] a, int low, int high) {
    int pivot = a[low];
    int start = low;
    int end = high;

    while (start < end) {
      while (a[start] <= pivot) {
        if (start == high) break;
        start++;
      }

      while (a[end] >= pivot) {
        if (end == low) break;
        end--;
      }

      if (start < end) swap(a, start, end);
    }

    swap(a, low, end);
    return end;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static boolean isSorted(int[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i] < a[i - 1]) return false;
    }
    return true;
  }

  public static void main(String[] args) {

    int[] a = {10, 9, 8, 8, 7, 6, 3, 3, -1, 2, 1};
    sort(a);
    assert isSorted(a);
    StdOut.println(Arrays.toString(a));

    int[] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sort(b);
    assert isSorted(b);
    StdOut.println(Arrays.toString(b));
  }
}
