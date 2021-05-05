package algoexpert.heaps;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays2 {
  static class Item implements Comparable<Item> {
    public int arrayIndex, elementIndex, value;

    Item(int arrayIndex, int elementIndex, int value) {
      this.arrayIndex = arrayIndex;
      this.elementIndex = elementIndex;
      this.value = value;
    }

    @Override
    public String toString() {
      return "Item{"
          + "arrayIndex="
          + arrayIndex
          + ", elementIndex="
          + elementIndex
          + ", value="
          + value
          + '}';
    }

    @Override
    public int compareTo(Item o) {
      if (this.value == o.value) return 0;
      if (this.value < o.value) return -1;
      return 1;
    }
  }

  public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
    List<Integer> sortedList = new ArrayList<>();
    List<Item> smallestItems = new ArrayList<>();

    for (int i = 0; i < arrays.size(); i++) {
      smallestItems.add(new Item(i, 0, arrays.get(i).get(0)));
    }

    MinPQ<Item> minPQ =
        new MinPQ<Item>((Item[]) smallestItems.toArray(new Item[smallestItems.size()]));

    while (!minPQ.isEmpty()) {
      Item smallestItem = minPQ.delMin();
      sortedList.add(smallestItem.value);

      if (smallestItem.elementIndex == arrays.get(smallestItem.arrayIndex).size() - 1) continue;

      minPQ.insert(
          new Item(
              smallestItem.arrayIndex,
              smallestItem.elementIndex + 1,
              arrays.get(smallestItem.arrayIndex).get(smallestItem.elementIndex + 1)));
    }

    return sortedList;
  }

  public static void main(String[] args) {

    List<List<Integer>> arrays = new ArrayList<List<Integer>>();
    arrays.add(Arrays.asList(new Integer[] {1, 5, 9, 21}));
    arrays.add(Arrays.asList(new Integer[] {-1, 0}));
    arrays.add(Arrays.asList(new Integer[] {-124, 81, 121}));
    arrays.add(Arrays.asList(new Integer[] {3, 6, 12, 20, 150}));
    StdOut.println(mergeSortedArrays(arrays));

    //    Item a = new Item(1, 10);
    //    Item b = new Item(1, 9);
    //    Item c = new Item(1, 8);
    //    Item d = new Item(1, 7);
    //    Item e = new Item(1, 6);
    //
    //    MinPQ<Item> pq = new MinPQ<>();
    //    pq.insert(a);
    //    pq.insert(b);
    //    pq.insert(c);
    //    pq.insert(d);
    //    pq.insert(e);
    //
    //    StdOut.println(pq.delMin().value);
    //    StdOut.println(pq.delMin().value);
    //    StdOut.println(pq.delMin().value);
    //    StdOut.println(pq.delMin().value);
    //    StdOut.println(pq.delMin().value);
  }
}
