package algoexpert.bst;

class BinaryTreeDiameter {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  static class NodeInfo {
    int height;
    int diameter;

    NodeInfo(int diameter, int height) {
      this.height = height;
      this.diameter = diameter;
    }
  }

  public int binaryTreeDiameter(BinaryTree root) {
    return dfs(root).diameter;
  }

  private NodeInfo dfs(BinaryTree node) {
    if (node == null) return new NodeInfo(0, 0);

    NodeInfo left = dfs(node.left);
    NodeInfo right = dfs(node.right);

    int diameter = Math.max(left.diameter + right.diameter, left.height + right.height);

    return new NodeInfo(diameter, Math.max(left.height, right.height) + 1);
  }
}
