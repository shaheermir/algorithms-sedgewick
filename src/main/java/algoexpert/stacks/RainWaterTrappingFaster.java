package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

public class RainWaterTrappingFaster {
  /**
   * @param a - building heights
   * @return total area that gets trapped between all the buildings.
   */
  public static int rainWaterTrapping(int[] a) {
    int totalArea = 0;
    int[] areas = new int[a.length];

    int[] leftSideMaxValues = findMaxValuesOnLeftSide(a);
    int[] rightSideMaxValues = findMaxValuesOnRightSide(a);

    for (int i = 0; i < a.length; i++) {
      int leftSideMax = leftSideMaxValues[i];
      int rightSideMax = rightSideMaxValues[i];
      int height = Math.min(leftSideMax, rightSideMax) - a[i];
      areas[i] = height;
    }

    for (int area : areas) totalArea += area;
    return totalArea;
  }

  private static int[] findMaxValuesOnLeftSide(int[] a) {
    int max = a[0];
    int[] maxValuesOnLeftSide = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) max = a[i];

      maxValuesOnLeftSide[i] = max;
    }

    return maxValuesOnLeftSide;
  }

  private static int[] findMaxValuesOnRightSide(int[] a) {
    int max = a[a.length - 1];
    int[] maxValuesOnRightSide = new int[a.length];

    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i] > max) max = a[i];
      maxValuesOnRightSide[i] = max;
    }

    return maxValuesOnRightSide;
  }

  public static void main(String[] args) {
    int[] buildingHeights = {3, 0, 0, 2, 0, 4};
    StdOut.println(rainWaterTrapping(buildingHeights));
  }
}
