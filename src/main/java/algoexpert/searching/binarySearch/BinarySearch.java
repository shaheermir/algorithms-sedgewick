package algoexpert.searching.binarySearch;

public class BinarySearch {
  public static int binarySearch(int[] a, int target) {
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
}
