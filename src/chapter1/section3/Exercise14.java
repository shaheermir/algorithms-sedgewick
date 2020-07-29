package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Exercise14 {
  public static class ResizingArrayQueueOfStrings {
    private int size = 0;
    private int first = 0;
    private int last = 0;
    private String[] array = new String[1];

    public int size() {
      return size;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public void enqueue(String value) {
      if (size == array.length) resize(array.length * 2);
      array[last++] = value;
      if (last == array.length) last = 0;
      size++;
    }

    public String dequeue() {
      if (isEmpty()) throw new NoSuchElementException("Queue is empty");

      String value = array[first];
      array[first] = null;
      size--;
      first++;

      if (first == array.length) first = 0;
      if (size > 0 && size == array.length / 4) resize(array.length / 2);
      return value;
    }

    private void resize(int length) {
      assert length >= size;
      String[] temp = new String[length];
      for (int i = 0; i < size; i++) temp[i] = array[(i + first) % array.length];
      array = temp;
      first = 0;
      last = size;
    }

    @Override
    public String toString() {
      return "ResizingArrayQueueOfStrings{"
          + "size="
          + size
          + ", first="
          + first
          + ", last="
          + last
          + ", array="
          + Arrays.toString(array)
          + '}';
    }
  }

  public static void main(String[] args) {
    ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
    q.enqueue("m");
    StdOut.println(q.dequeue());

    q.enqueue("i");
    q.enqueue("r");
    StdOut.println(q);
    q.enqueue("x");
    StdOut.println(q);

    StdOut.println(q.dequeue());
    StdOut.println(q.dequeue());
  }
}
