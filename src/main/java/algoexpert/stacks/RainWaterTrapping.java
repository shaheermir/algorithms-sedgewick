package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class RainWaterTrapping {
  /**
   * @param a - building heights
   * @return total area that gets trapped between all the buildings.
   */
  public static int rainWaterTrapping(int[] a) {
    int totalArea = 0;
    int[] areas = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      int leftSideMax = findMaxOnLeftSide(a, i);
      int rightSideMax = findMaxOnRightSide(a, i);
      int height = Math.min(leftSideMax, rightSideMax) - a[i];
      areas[i] = height;
    }

    StdOut.println(Arrays.toString(areas));
    for (int area : areas) totalArea += area;
    return totalArea;
  }

  // max including the current element
  private static int findMaxOnLeftSide(int[] a, int index) {
    int currentMax = a[0];
    for (int i = 0; i <= index; i++) {
      if (a[i] > currentMax) currentMax = a[i];
    }
    return currentMax;
  }

  // max including the current element
  private static int findMaxOnRightSide(int[] a, int index) {
    int currentMax = a[a.length - 1];
    for (int i = a.length - 1; i >= index; i--) {
      if (a[i] > currentMax) currentMax = a[i];
    }
    return currentMax;
  }

  public static void main(String[] args) {
    int[] buildingHeights = {3, 0, 0, 2, 0, 4};

    StdOut.println(rainWaterTrapping(buildingHeights));
  }
}
