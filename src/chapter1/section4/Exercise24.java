package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise24 {
  public static void main(String[] args) {
    int[] floors = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
    StdOut.println("- - - O(log N) - - -\n");
    StdOut.println("Building Floors: " + Arrays.toString(floors));
    StdOut.println("Tipping Floor: " + findFloorInLogN(floors));

    StdOut.println("\n- - - 2(log F) - - - Where N >> F\n");

    int[] floors2 = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    int[] floors3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    int[] floors4 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    StdOut.println(Arrays.toString(floors2));
    StdOut.println(findFloorInLogF(floors2));
    StdOut.println();

    StdOut.println(Arrays.toString(floors3));
    StdOut.println(findFloorInLogF(floors3));
    StdOut.println();

    StdOut.println(Arrays.toString(floors4));
    StdOut.println(findFloorInLogF(floors4));
    StdOut.println();
  }

  private static int findFloorInLogN(int[] floors) {
    return findFloorInLogN(floors, 0, floors.length - 1);
  }

  private static int findFloorInLogN(int[] floors, int left, int right) {
    // run a binary search looking for the left most 1.
    int key = 1;
    int index = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (floors[mid] == key) {
        index = mid;
        right = mid - 1;
      } else if (floors[mid] < key) {
        left = mid + 1;
      }
    }

    return index;
  }

  /**
   * N (floors.length) is much larger than F (index of tipping floor) Therefore, we will start
   * search from 0, and use repeated doubling to find a floor that breaks.
   *
   * <p>That floor is not necessarily the tipping floor. Thats why we'll then run a binary search on
   * the bounds we found earlier.
   */
  private static int findFloorInLogF(int[] floors) {
    int key = 1;
    if (floors[0] == key) return 0;

    int breakingEggFloor = -1;

    for (int i = 1; i < floors.length; i = i * 2) {
      if (floors[i] == key) {
        breakingEggFloor = i;
        break;
      }
    }

    if (breakingEggFloor == -1) return breakingEggFloor;

    int prevFloorWithoutBreakage = breakingEggFloor / 2;
    return findFloorInLogN(floors, prevFloorWithoutBreakage, breakingEggFloor);
  }
}
