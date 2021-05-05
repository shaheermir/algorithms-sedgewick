package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

// Min element is the one who is smaller than its previous element.
// this is the key here
public class MinElementInSortedRotatedArray {

  // O(log n ) avg
  // O(n) worst case when all elements are same
  public static int findMin(int[] a, int left, int right) {
    if (left == right || a[left] < a[right]) {
      return a[left];
    }

    int mid = (left + right) / 2;

    // check if mid+1 is a min element
    if (mid < right && a[mid + 1] < a[mid]) return a[mid + 1];

    // check if mid itself is a min element
    if (mid > left && a[mid] < a[mid - 1]) return a[mid];

    if (a[mid] > a[left]) return findMin(a, mid + 1, right);
    return findMin(a, left, mid - 1);
  }

  // https://www.youtube.com/watch?v=GU7DpgHINWQ&ab_channel=Errichto
  public static int findMin(int[] a) {
    int ans = -1;

    int last = a.length - 1;
    int left = 0;
    int right = last;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid] <= a[last]) {
        ans = a[mid];
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {5, 6, 0, 1, 1, 1, 1, 1, 2, 3, 4};
    int[] b = {1, 2, 3, 4, 5, 6};
    int[] bRotated = {6, 1, 2, 3, 4, 5};

    int[] c = {5, 6, 4, 3, 1, 2};

    StdOut.println(findMin(a, 0, a.length - 1) + " Expected 0");
    StdOut.println(findMin(b, 0, b.length - 1) + " Expected 1");
    StdOut.println(findMin(bRotated, 0, bRotated.length - 1) + " Expected 1");

    StdOut.println();
    StdOut.println(findMin(a) + " Expected 0");
    StdOut.println(findMin(b) + " Expected 1");
    StdOut.println(findMin(bRotated) + " Expected 1");
    StdOut.println(findMin(c) + " Expected 1");
  }
}

//  public static int findMin(int[] a) {
//    int left = 0;
//    int right = a.length - 1;
//
//    while (left < right) {
//      int mid = (left + right) / 2;
//
//      if (a[mid] == a[right]) right--;
//      else if (a[mid] > a[right]) left = mid + 1;
//      else right = mid;
//    }
//
//    return a[left];
//  }
