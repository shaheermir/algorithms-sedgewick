package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class SunsetViews {
  public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

    boolean[] visible = new boolean[buildings.length];

    int startIndex = buildings.length - 1;
    int step = -1;

    if (direction.equals("WEST")) {
      startIndex = 0;
      step = 1;
    }

    int currentMax = Integer.MIN_VALUE;
    for (int i = startIndex; i >= 0 && i < buildings.length; i += step) {
      int height = buildings[i];
      if (height > currentMax) {
        currentMax = height;
        visible[i] = true;
      }
    }

    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < visible.length; i++) if (visible[i]) result.add(i);

    return result;
  }

  public static void main(String[] args) {
    StdOut.println(sunsetViews(new int[] {3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
  }
}
