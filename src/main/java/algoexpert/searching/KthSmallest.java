package algoexpert.searching;

import edu.princeton.cs.algs4.StdOut;

public class KthSmallest {
  public static int findKthSmallest(int[] a, int k) {
    assert k >= 1 && k <= a.length;
    return quickSelect(a, 0, a.length - 1, k - 1);
  }

  private static int quickSelect(int[] a, int left, int right, int rank) {
    if (left == right) return a[left];
    int pivotIndex = partition(a, left, right);

    if (pivotIndex == rank) return a[rank];

    if (pivotIndex < rank) return quickSelect(a, pivotIndex + 1, right, rank);
    else return quickSelect(a, left, pivotIndex - 1, rank);
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
    int[] a = {9, 8, 5, 2, 9, 7, 6, 3};
    int k = 3;
    int expected = 5;

    StdOut.println(findKthSmallest(a, k) + " Expected " + expected);
  }
}
