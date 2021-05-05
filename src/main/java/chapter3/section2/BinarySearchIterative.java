package chapter3.section2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BinarySearchIterative<Key extends Comparable<Key>, Value> {
  private class Node {
    Key key;
    Value value;

    Node left;
    Node right;

    int size;

    Node(Key key, Value value, int size) {
      this.key = key;
      this.value = value;
      this.size = size;
    }
  }

  private Node root;

  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) return 0;
    return node.size;
  }

  public Value get(Key key) {
    Node current = root;

    while (current != null) {
      int comparison = key.compareTo(current.key);
      if (comparison < 0) {
        current = current.left;
      } else if (comparison > 0) {
        current = current.right;
      } else {
        return current.value;
      }
    }

    return null;
  }

  public void put(Key key, Value value) {
    if (root == null) {
      root = new Node(key, value, 1);
      return;
    }

    boolean keyExists = false;

    Node current = root;
    while (current != null) {
      int comparison = key.compareTo(current.key);
      if (comparison < 0) {
        current = current.left;
      } else if (comparison > 0) {
        current = current.right;
      } else {
        current.value = value;
        keyExists = true;
      }
    }

    if (keyExists) return;

    current = root;
    while (current != null) {
      current.size = current.size + 1;
      int compare = key.compareTo(current.key);

      if (compare < 0) {
        if (current.left != null) current = current.left;
        else {
          current.left = new Node(key, value, 1);
          return;
        }
      } else if (compare > 0) {
        if (current.right != null) current = current.right;
        else {
          current.right = new Node(key, value, 1);
          return;
        }
      }
    }
  }

  public Key min() {
    if (root == null) return null;

    Node current = root;
    while (current != null) {
      if (current.left == null) return current.key;
      else current = current.left;
    }

    return null;
  }

  public Key max() {
    if (root == null) return null;

    Node current = root;

    while (current != null) {
      if (current.right == null) return current.key;
      else current = current.right;
    }

    return null;
  }

  public Key floor(Key key) {
    Node current = root;
    Key currentFloor = null;

    while (current != null) {
      int compaison = key.compareTo(current.key);
      if (compaison < 0) {
        current = current.left;
      } else if (compaison > 0) {
        currentFloor = current.key;
        current = current.right;
      } else {
        currentFloor = current.key;
        break;
      }
    }

    return currentFloor;
  }

  public Key ceiling(Key key) {
    Node current = root;
    Key currentCeiling = null;

    while (current != null) {
      int compaison = key.compareTo(current.key);

      if (compaison < 0) {
        currentCeiling = current.key;
        current = current.left;
      } else if (compaison > 0) {
        current = current.right;
      } else {
        currentCeiling = current.key;
        break;
      }
    }

    return currentCeiling;
  }

  public int rank(Key key) {
    Node current = root;

    int rank = 0;

    while (current != null) {
      int comparison = key.compareTo(current.key);

      if (comparison < 0) current = current.left;
      else if (comparison > 0) {
        rank = rank + size(current.left) + 1;
        current = current.right;
      } else {
        rank = rank + size(current.left);
        return rank;
      }
    }

    return rank;
  }

  public Key select(int index) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

    Node current = root;
    while (current != null) {
      int leftSubtreeSize = size(current.left);

      if (leftSubtreeSize == index) {
        return current.key;
      } else if (leftSubtreeSize > index) {
        current = current.left;
      } else if (leftSubtreeSize < index) {
        index = index - (leftSubtreeSize + 1);
        current = current.right;
      }
    }

    return null;
  }

  public Iterable<Key> keys() {
    Queue<Key> q = new Queue<>();

    Stack<Node> stack = new Stack<>();

    Node current = root;
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        current = stack.pop();
        q.enqueue(current.key);
        current = current.right;
      }
    }

    return q;
  }
}
