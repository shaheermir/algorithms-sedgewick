package algoexpert.heaps;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortedArrays {
  static class Item {
    public int arrayIndex, value;

    Item(int arrayIndex, int value) {
      this.arrayIndex = arrayIndex;
      this.value = value;
    }
  }

  public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
    ArrayList<Integer> sortedList = new ArrayList<>();
    ArrayList<Integer> elementIndices =
        new ArrayList<Integer>(Collections.nCopies(arrays.size(), 0));

    while (true) {
      ArrayList<Item> smallestItems = new ArrayList<Item>();

      for (int arrayIndex = 0; arrayIndex < arrays.size(); arrayIndex++) {
        List<Integer> relevantArray = arrays.get(arrayIndex);
        int elementIdx = elementIndices.get(arrayIndex);
        if (elementIdx == relevantArray.size()) continue;
        smallestItems.add(new Item(arrayIndex, relevantArray.get(elementIdx)));
      }

      if (smallestItems.size() == 0) break;
      Item item = getMinItem(smallestItems);
      sortedList.add(item.value);
      elementIndices.set(item.arrayIndex, elementIndices.get(item.arrayIndex) + 1);
    }

    return sortedList;
  }

  private static Item getMinItem(ArrayList<Item> items) {
    Item smallestItem = items.get(0);
    for (Item i : items) {
      if (i.value < smallestItem.value) smallestItem = i;
    }
    return smallestItem;
  }

  public static void main(String[] args) {

    List<List<Integer>> arrays = new ArrayList<List<Integer>>();
    arrays.add(Arrays.asList(new Integer[] {1, 5, 9, 21}));
    arrays.add(Arrays.asList(new Integer[] {-1, 0}));
    arrays.add(Arrays.asList(new Integer[] {-124, 81, 121}));
    arrays.add(Arrays.asList(new Integer[] {3, 6, 12, 20, 150}));
    StdOut.println(mergeSortedArrays(arrays));
  }
}
