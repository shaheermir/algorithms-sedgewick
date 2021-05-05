package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Iterable<T> {
  int size = 0;
  private T[] array = (T[]) new Object[1];

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void resize(int length) {
    T[] temp = (T[]) new Object[length];
    for (int i = 0; i < size; i++) temp[i] = array[i];
    array = temp;
  }

  public T peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return array[size - 1];
  }

  public void push(T item) {
    if (size == array.length) resize(size * 2);
    array[size++] = item;
  }

  public T pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");

    T item = array[--size];
    array[size] = null;

    if (size > 0 && size == array.length / 4) {
      resize(array.length / 2);
    }

    return item;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int i = size;

      @Override
      public boolean hasNext() {
        return i > 0;
      }

      @Override
      public T next() {
        return array[--i];
      }
    };
  }

  public static void main(String[] args) {
    ArrayStack<Integer> stack = new ArrayStack<Integer>();

    StdOut.println("Pushing 1 2 3");
    stack.push(1);
    stack.push(2);
    stack.push(3);

    StdOut.println();
    StdOut.println("Size is " + stack.size());

    StdOut.println();
    StdOut.println("Peeking: " + stack.peek());

    StdOut.println();
    StdOut.println("Popped: " + stack.pop());

    StdOut.println();
    StdOut.println("Popped: " + stack.pop());

    StdOut.println();
    StdOut.println("Size is " + stack.size());

    StdOut.println("Pushing 2 3 4 5 6 6 7 8 9");
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);
    stack.push(9);

    StdOut.println();
    StdOut.println("Size is " + stack.size());

    StdOut.println();
    StdOut.println("Peeking: " + stack.peek());

    StdOut.println();
    StdOut.println("Printing Stack");
    for (int n : stack) {
      StdOut.println(n);
    }

    StdOut.println();
    StdOut.println("Size is " + stack.size());

    StdOut.println();
    StdOut.println("Peeking: " + stack.peek());
  }
}
