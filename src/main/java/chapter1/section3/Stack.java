package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
  private class Node {
    T data;
    Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  private int size;
  private Node head;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");

    return head.data;
  }

  public void push(T data) {
    Node node = new Node(data);
    node.next = head;
    head = node;
    size++;
  }

  public T pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");

    T item = head.data;
    head = head.next;
    size--;

    return item;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        T data = current.data;
        current = current.next;
        return data;
      }
    };
  }

  public static void main(String[] args) {
    Stack<Integer> numbers = new Stack<Integer>();

    StdOut.println("Pushing 1 2 3 ");
    numbers.push(1);
    numbers.push(2);
    numbers.push(3);
    StdOut.println("Size is " + numbers.size() + "\n");

    StdOut.printf("Popped - %d\n", numbers.pop());
    StdOut.printf("Popped - %d\n", numbers.pop());
    StdOut.printf("Popped - %d\n", numbers.pop());
    StdOut.println("Size is " + numbers.size());

    StdOut.println("\nPushing 4");
    numbers.push(4);
    StdOut.println("Size is " + numbers.size());

    StdOut.printf("Popped - %d", numbers.pop());
    StdOut.println("\nSize is " + numbers.size() + "\n");

    StdOut.println("Pushing 7 8 9 ");
    numbers.push(7);
    numbers.push(8);
    numbers.push(9);
    StdOut.println("Iterating through the stack.");
    for (int n : numbers) {
      StdOut.println(n);
    }
    StdOut.println("Size is " + numbers.size());
    StdOut.println("\nPeeking " + numbers.peek());
  }
}
