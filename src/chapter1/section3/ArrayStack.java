package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T> {

    private int size = 0;
    private T[] array = (T[]) new Object[1];

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T item) {
        if (size == array.length) resize(array.length * 2);
        array[size] = item;
        size++;
    }

    public T peek() {
        if (size == 0) throw new NullPointerException("Stack is empty!");
        return array[size - 1];
    }

    public T pop() {
        if (size == 0) throw new NullPointerException("Stack is empty!");

        size--;
        T item = array[size];
        array[size] = null;

        if (size > 0 && size == array.length / 4)
            resize(array.length / 2);

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

    private void resize(int length) {
        T[] temp = (T[]) new Object[length];
        for (int i = 0; i < size; i++)
            temp[i] = array[i];
        array = temp;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> numbers = new ArrayStack<>();

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

