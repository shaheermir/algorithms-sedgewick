package chapter3.section2.practice;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class BST_Recursive<Key extends Comparable<Key>, Value> {
  private class Node {
    Key key;
    Value value;

    Node left;
    Node right;

    int size;
    int height;
    double xCoordinate, yCoordinate;

    Node(Key key, Value value, int size) {
      this.key = key;
      this.value = value;
      this.size = size;
    }
  }

  int treeLevel;
  private Node root;

  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) return 0;
    return node.size;
  }

  public int height() {
    return height(root);
  }

  private int height(Node node) {
    if (node == null) return -1;
    return node.height;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public Value get(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison < 0) return get(node.left, key);
    else if (comparison > 0) return get(node.right, key);
    else return node.value;
  }

  public Key min() {
    if (isEmpty()) return null;
    return min(root).key;
  }

  private Node min(Node node) {
    if (node.left == null) return node;
    return min(node.left);
  }

  public Key max() {
    if (isEmpty()) return null;
    return max(root).key;
  }

  private Node max(Node node) {
    if (node.right == null) return node;
    return max(node.right);
  }

  public Key floor(Key key) {
    if (key == null) throw new IllegalArgumentException();

    Node node = floor(root, key);
    if (node == null) return null;
    return node.key;
  }

  private Node floor(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison == 0) {
      return node;
    } else if (comparison < 0) {
      return floor(node.left, key);
    } else {
      Node rightNode = floor(node.right, key);
      return rightNode == null ? node : rightNode;
    }
  }

  public Key ceiling(Key key) {
    if (key == null) throw new IllegalArgumentException();

    Node node = ceiling(root, key);
    return node == null ? null : node.key;
  }

  private Node ceiling(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison == 0) return node;
    else if (comparison > 0) return ceiling(node.right, key);
    else { // (comparison < 0)
      Node leftNode = ceiling(node.left, key);
      return leftNode == null ? node : leftNode;
    }
  }

  public void put(Key key, Value value) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    if (value == null) delete(key);

    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) return new Node(key, value, 1);
    int comparison = key.compareTo(node.key);

    if (comparison < 0) node.left = put(node.left, key, value);
    else if (comparison > 0) node.right = put(node.right, key, value);
    else node.value = value;

    node.size = size(node.left) + 1 + size(node.right);
    node.height = Math.max(height(node.left), height(node.right)) + 1;

    return node;
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  private Node deleteMin(Node node) {
    if (node == null) return null;
    if (node.left == null) return node.right;

    node.left = deleteMin(node.left);

    node.size = size(node.left) + 1 + size(node.right);
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    return node;
  }

  private void deleteMax() {
    root = deleteMax(root);
  }

  private Node deleteMax(Node node) {
    if (node == null) return null;

    if (node.right == null) return node.left;

    node.right = deleteMax(node.right);
    node.size = size(node.left) + 1 + size(node.right);
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    return node;
  }

  public void delete(Key key) {
    root = delete(root, key);
  }

  private Node delete(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison < 0) {
      node.left = delete(node.left, key);
    } else if (comparison > 0) {
      node.right = delete(node.right, key);
    } else {
      if (node.left == null) return node.right;
      if (node.right == null) return node.left;

      Node toBeDeleted = node;
      node = min(node.right);
      node.right = deleteMin(toBeDeleted.right);
      node.left = toBeDeleted.left;
    }

    node.size = size(node.left) + 1 + size(node.right);
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    return node;
  }

  public int rank(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    return rank(root, key);
  }

  private int rank(Node node, Key key) {
    if (node == null) return 0;

    int comparison = key.compareTo(node.key);

    if (comparison < 0) return rank(node.left, key);
    else if (comparison > 0) return size(node.left) + 1 + rank(node.right, key);
    else return size(node.left);
  }

  public Key select(int index) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

    return select(root, index).key;
  }

  private Node select(Node node, int index) {
    if (node == null) return null;

    int leftSubtreeSize = size(node.left);

    if (leftSubtreeSize == index) return node;
    else if (leftSubtreeSize > index) return select(node.left, index);
    else return select(node.right, index - leftSubtreeSize - 1);
  }

  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  public Iterable<Key> keys(Key low, Key high) {
    Queue<Key> q = new Queue<>();
    keys(root, q, low, high);
    return q;
  }

  private void keys(Node node, Queue<Key> q, Key low, Key high) {
    if (node == null) return;

    int compareLow = low.compareTo(node.key);
    int compareHigh = high.compareTo(node.key);

    if (compareLow < 0) keys(node.left, q, low, high);
    if (compareLow <= 0 && compareHigh >= 0) q.enqueue(node.key);
    if (compareHigh > 0) keys(node.right, q, low, high);
  }

  public void printInOrder() {
    printInOrder(root);
  }

  private void printInOrder(Node node) {
    if (node == null) return;
    printInOrder(node.left);
    StdOut.print(node.key + " ");
    printInOrder(node.right);
  }

  public void printPreOrder() {
    printPreOrder(root);
  }

  private void printPreOrder(Node node) {
    if (node == null) return;
    StdOut.print(node.key + " ");
    printPreOrder(node.left);
    printPreOrder(node.right);
  }

  public void printPostOrder() {
    printPostOrder(root);
  }

  private void printPostOrder(Node node) {
    if (node == null) return;
    printPostOrder(node.left);
    printPostOrder(node.right);
    StdOut.print(node.key + " ");
  }

  public Iterable<Key> levelOrderKeys() {
    ArrayList<Key> list = new ArrayList<>();
    if (isEmpty()) return list;

    Queue<Node> q = new Queue<>();
    q.enqueue(root);
    levelOrderKeys(list, q);
    return list;
  }

  private void levelOrderKeys(ArrayList<Key> list, Queue<Node> q) {
    if (q.isEmpty()) return;

    Node node = q.dequeue();
    list.add(node.key);

    if (node.left != null) q.enqueue(node.left);
    if (node.right != null) q.enqueue(node.right);

    levelOrderKeys(list, q);
  }

  public void draw() {
    treeLevel = 0;
    setCoordinates(root, 1);

    StdDraw.setPenColor(StdDraw.BLACK);
    drawLines(root);
    drawNodes(root);
  }

  private void setCoordinates(Node node, double distance) {
    if (node == null) return;
    setCoordinates(node.left, distance - 0.05);
    node.xCoordinate = (0.5 + (treeLevel++)) / size();
    node.yCoordinate = distance - 0.05;
    setCoordinates(node.right, distance - 0.05);
  }

  private void drawNodes(Node node) {
    if (node == null) return;

    double nodeRadius = 0.045;

    drawNodes(node.left);

    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledCircle(node.xCoordinate, node.yCoordinate, nodeRadius);

    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.circle(node.xCoordinate, node.yCoordinate, nodeRadius);
    StdDraw.text(node.xCoordinate, node.yCoordinate, (node.key) + ", " + (node.height));

    drawNodes(node.right);
  }

  private void drawLines(Node node) {
    if (node == null) return;

    drawLines(node.left);

    if (node.left != null) {
      StdDraw.line(
          node.xCoordinate, node.yCoordinate, node.left.xCoordinate, node.left.yCoordinate);
    }
    if (node.right != null) {
      StdDraw.line(
          node.xCoordinate, node.yCoordinate, node.right.xCoordinate, node.right.yCoordinate);
    }

    drawLines(node.right);
  }

  public static void main(String[] args) {
    BST_Recursive<Integer, Integer> tree = new BST_Recursive<>();
    tree.put(15, 15);
    tree.put(10, 10);
    tree.put(20, 20);
    tree.put(8, 8);
    tree.put(12, 12);
    tree.put(16, 16);
    tree.put(25, 25);
    tree.put(13, 13);
    tree.put(14, 14);
    tree.put(7, 7);
    tree.put(11, 11);

    tree.draw();

    StdOut.println("Min: " + tree.min() + " - Expected 7");
    StdOut.println("Max: " + tree.max() + " - Expected 25");

    StdOut.println();
    StdOut.println("Printing Tree In Order");
    tree.printInOrder();

    //    StdOut.println();
    //    StdOut.println("Deleting Min Value of 7");
    //    StdOut.println("Deleting Max Value of 25");
    //    tree.deleteMax();
    //    tree.deleteMin();
    //
    //    StdOut.println();
    //    StdOut.println("Min: " + tree.min() + " - Expected 8");
    //    StdOut.println("Max: " + tree.max() + " - Expected 20");

    StdOut.println("\n");
    StdOut.println("Printing Tree Pre Order");
    tree.printPreOrder();

    StdOut.println("\n");
    StdOut.println("Printing Tree Post Order");
    tree.printPostOrder();

    StdOut.println("\n");
    StdOut.println("Printing Tree Depth First");
    for (Integer i : tree.levelOrderKeys()) {
      StdOut.print(i + " ");
    }
  }
}
