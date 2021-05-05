package algoexpert.linkedlists;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

class DoublyLinkedList implements Iterable {
  @Override
  public Iterator iterator() {
    return new Iterator() {
      Node current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public Object next() {
        int value = current.value;
        current = current.next;
        return value;
      }
    };
  }

  @Override
  public String toString() {
    String list = "";

    int i = 0;
    for (Object item : this) {
      if (i == 0) list = list + item;
      else list = list + ", " + item;
      i++;
    }

    return "LinkedList{" + "list=" + list + '}';
  }

  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public Node head;
  public Node tail;

  public void setHead(Node node) {
    if (head == null) {
      head = node;
      tail = node;
      return;
    }
    insertBefore(head, node);
  }

  public void setTail(Node node) {
    if (tail == null) {
      setHead(node);
      return;
    }
    insertAfter(tail, node);
  }

  public void insertBefore(Node node, Node nodeToInsert) {
    if (nodeToInsert == head && nodeToInsert == tail) return;

    remove(nodeToInsert);
    nodeToInsert.prev = node.prev;
    nodeToInsert.next = node;

    if (node.prev == null) head = nodeToInsert;
    else node.prev.next = nodeToInsert;

    node.prev = nodeToInsert;
  }

  public void insertAfter(Node node, Node nodeToInsert) {
    if (nodeToInsert == head && nodeToInsert == tail) return;

    remove(nodeToInsert);
    nodeToInsert.prev = node;
    nodeToInsert.next = node.next;

    if (nodeToInsert.next == null) tail = nodeToInsert;
    else node.next.prev = nodeToInsert;

    node.next = nodeToInsert;
  }

  public void insertAtPosition(int position, Node nodeToInsert) {
    if (position == 1) {
      setHead(nodeToInsert);
      return;
    }

    Node current = head;
    int index = 1;
    while (current != null && index != position) {
      current = current.next;
      index++;
    }

    if (current != null) {
      insertBefore(current, nodeToInsert);
    } else {
      setTail(nodeToInsert);
    }
  }

  public void removeNodesWithValue(int value) {
    Node current = head;
    while (current != null) {
      Node nodeToRemove = current;
      current = current.next;
      if (nodeToRemove.value == value) remove(nodeToRemove);
    }
  }

  public void remove(Node node) {
    if (node == head) head = head.next;
    if (node == tail) tail = tail.prev;
    removeNodeBindings(node);
  }

  public boolean containsNodeWithValue(int value) {
    Node current = head;
    while (current != null) {
      if (current.value == value) return true;
      current = current.next;
    }
    return false;
  }

  private void removeNodeBindings(Node node) {
    if (node.prev != null) node.prev.next = node.next;
    if (node.next != null) node.next.prev = node.prev;
    node.prev = null;
    node.next = null;
  }

  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    list.setHead(new Node(1));
    list.setHead(new Node(2));

    StdOut.println(list);
  }
}
