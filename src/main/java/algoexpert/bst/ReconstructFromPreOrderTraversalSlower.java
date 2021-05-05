package algoexpert.bst;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class ReconstructFromPreOrderTraversalSlower {
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public BST reconstructBst(List<Integer> values) {
    if (values.size() == 0) return null;

    int value = values.get(0);

    int rightSubtreeIndex = values.size();
    for (int i = 1; i < values.size(); i++) {
      if (values.get(i) >= value) {
        rightSubtreeIndex = i;
        break;
      }
    }

    BST left = reconstructBst(values.subList(1, rightSubtreeIndex));
    BST right = reconstructBst(values.subList(rightSubtreeIndex, values.size()));

    BST node = new BST(value);
    node.left = left;
    node.right = right;
    return node;
  }

  private static void printPreorder(BST node) {
    if (node == null) return;
    StdOut.print(node.value + " ");
    printPreorder(node.left);
    printPreorder(node.right);
  }

  public static void main(String[] args) {
    ReconstructFromPreOrderTraversalSlower program = new ReconstructFromPreOrderTraversalSlower();
    List<Integer> preorder = Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18);
    BST root = program.reconstructBst(preorder);
    printPreorder(root);
  }
}
