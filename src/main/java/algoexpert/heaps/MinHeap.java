package algoexpert.heaps;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

class MinHeap {
  List<Integer> heap = new ArrayList<Integer>();

  public MinHeap() {}

  public MinHeap(List<Integer> array) {
    heap = buildHeap(array);
  }

  public List<Integer> buildHeap(List<Integer> a) {
    int firstParentIndex = (a.size() - 2) / 2;
    for (int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--) {
      siftDown(currentIndex, a.size() - 1, a);
    }
    return a;
  }

  public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
    int left = (2 * currentIdx) + 1;

    while (left <= endIdx) {
      int right = (2 * currentIdx) + 2;
      int smallerChild = left;

      if (right <= heap.size() - 1 && heap.get(right) < heap.get(left)) smallerChild = right;

      if (smallerChild >= heap.size() || heap.get(currentIdx) < heap.get(smallerChild)) break;

      swap(heap, currentIdx, smallerChild);
      currentIdx = smallerChild;
      left = (2 * currentIdx) + 1;
    }
  }

  public void siftUp(int currentIdx, List<Integer> heap) {
    while (currentIdx > 0) {
      int parentIndex = (currentIdx - 1) / 2;
      if (heap.get(currentIdx) >= heap.get(parentIndex)) break;
      swap(heap, currentIdx, parentIndex);
      currentIdx = parentIndex;
    }
  }

  public int peek() {
    return heap.get(0);
  }

  public int remove() {
    int val = heap.get(0);
    swap(heap, 0, heap.size() - 1);
    heap.remove(heap.size() - 1);
    siftDown(0, heap.size() - 1, heap);
    return val;
  }

  public void insert(int value) {
    heap.add(value);
    siftUp(heap.size() - 1, heap);
  }

  private void swap(List<Integer> a, int i, int j) {
    int temp = a.get(i);
    a.set(i, a.get(j));
    a.set(j, temp);
  }

  public static void main(String[] args) {
    MinHeap heap = new MinHeap();
    heap.insert(1);
    StdOut.println("peek " + heap.peek());

    heap.insert(2);
    heap.insert(3);
    heap.insert(4);
    heap.insert(5);
    heap.insert(6);

    StdOut.println(heap.remove());
    StdOut.println(heap.remove());

    StdOut.println(heap.heap);
    StdOut.println(heap.remove());
    StdOut.println(heap.remove());
  }
}
