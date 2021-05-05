package algoexpert.bst;

import edu.princeton.cs.algs4.StdOut;

public class ConstructBST {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      if (value < this.value) {
        if (left == null) this.left = new BST(value);
        else left.insert(value);
      } else {
        if (right == null) this.right = new BST(value);
        else right.insert(value);
      }
      return this;
    }

    public boolean contains(int value) {
      if (value < this.value) {
        if (left == null) return false;
        return left.contains(value);
      } else if (value > this.value) {
        if (right == null) return false;
        return right.contains(value);
      }
      return true;
    }

    public BST remove(int value) {
      remove(value, null);
      return this;
    }

    private void remove(int value, BST parent) {
      if (value < this.value) {
        if (left != null) left.remove(value, this);
      } else if (value > this.value) {
        if (right != null) right.remove(value, this);
      } else {
        if (parent == null) {
          if (left == null && right == null) return;
          else if (left == null) {
            this.value = right.value;
            right = right.left != null ? right.left : right.right;
          } else if (right == null) {
            this.value = left.value;
            left = left.left != null ? left.left : left.right;
          } else {
            this.value = right.min();
            right.remove(this.value, this);
          }
          return;
        }

        if (left != null & right != null) {
          this.value = right.min();
          right.remove(this.value, this);
          return;
        }

        if (parent.left == this) {
          parent.left = left != null ? left : right;
        } else if (parent.right == this) {
          parent.right = left != null ? left : right;
        }
      }
    }

    private int min() {
      if (left == null) return this.value;
      return left.min();
    }
  }

  public static void main(String[] args) {
    BST root = new BST(10);
    //    root.insert(5);

    root.remove(10);

    StdOut.println(root.value);
  }
}
