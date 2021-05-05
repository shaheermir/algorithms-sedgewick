package chapter3.section2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Exercise6_BST_Height<Key extends Comparable<Key>, Value> {
  private class Node {
    Key key;
    Value value;

    Node left;
    Node right;

    int size; // # of nodes in the subtree rooted here
    int height; // max(# of edges from this node to leaf nodes)
    double xCoordinate, yCoordinate;

    public Node(Key key, Value value, int size) {
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

  public boolean isEmpty() {
    return size() == 0;
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison < 0) return get(node.left, key);
    else if (comparison > 0) return get(node.right, key);
    return node.value;
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  public Key min() {
    if (root == null) return null;
    return min(root).key;
  }

  private Node min(Node node) {
    if (node.left == null) return node;
    return min(node.left);
  }

  public Key max() {
    if (root == null) return null;
    return max(root).key;
  }

  private Node max(Node node) {
    if (node.right == null) return node;
    return max(node.right);
  }

  public void put(Key key, Value value) {
    if (key == null) return;
    if (value == null) {
      delete(key);
      return;
    }

    root = put(root, key, value);
  }

  public int heightRecursive() {
    return heightRecursive(root);
  }

  public int heightRecursive(Node node) {
    if (node == null) return -1;

    int leftHeight = heightRecursive(node.left);
    int rightHeight = heightRecursive(node.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  public int heightConstant() {
    return heightConstant(root);
  }

  public int heightConstant(Node node) {
    if (node == null) return -1;
    return node.height;
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) return new Node(key, value, 1);

    int comparison = key.compareTo(node.key);

    if (comparison < 0) {
      node.left = put(node.left, key, value);
    } else if (comparison > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }

    node.height = Math.max(heightConstant(node.left), heightConstant(node.right)) + 1;
    node.size = size(node.left) + 1 + size(node.right);
    return node;
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  private Node deleteMin(Node node) {
    if (node == null) return null;

    if (node.left == null) {
      return node.right;
    }

    node.left = deleteMin(node.left);
    node.size = size(node.left) + 1 + size(node.right);
    node.height = Math.max(heightConstant(node.left), heightConstant(node.right)) + 1;

    return node;
  }

  public void deleteMax() {
    root = deleteMax(root);
  }

  private Node deleteMax(Node node) {
    if (node == null) return null;

    if (node.right == null) {
      return node.left;
    }

    node.right = deleteMax(node.right);
    node.size = size(node.left) + 1 + size(node.right);
    node.height = Math.max(heightConstant(node.left), heightConstant(node.right)) + 1;
    return node;
  }

  public void delete(Key key) {
    if (key == null) return;
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
    node.height = Math.max(heightConstant(node.left), heightConstant(node.right)) + 1;
    return node;
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
    Exercise6_BST_Height<Integer, Integer> tree = new Exercise6_BST_Height<>();
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

    tree.delete(12);
    tree.delete(13);

    StdOut.println("Tree height (constant) is: " + tree.heightConstant());
    StdOut.println("Tree height (recursive) is: " + tree.heightRecursive());
    StdDraw.clear(StdDraw.WHITE);
    tree.draw();
  }
}
