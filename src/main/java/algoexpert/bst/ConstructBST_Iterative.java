package algoexpert.bst;

public class ConstructBST_Iterative {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      BST current = this;

      while (current != null) {
        if (value < current.value) {
          if (current.left == null) {
            current.left = new BST(value);
            break;
          } else current = current.left;
        } else {
          if (current.right == null) {
            current.right = new BST(value);
            break;
          } else current = current.right;
        }
      }

      return this;
    }

    public boolean contains(int value) {
      BST current = this;
      while (current != null) {
        if (value < current.value) current = current.left;
        else if (value > current.value) current = current.right;
        else return true;
      }
      return false;
    }

    public BST remove(int value) {
      remove(value, null);
      return this;
    }

    public void remove(int value, BST parent) {
      BST current = this;

      while (current != null) {
        if (value < current.value) {
          parent = current;
          current = current.left;
        } else if (value > current.value) {
          parent = current;
          current = current.right;
        } else {
          if (current.left != null && current.right != null) {
            current.value = current.right.getMinValue();
            current.right.remove(current.value, current);
            return;
          }

          // deletion of roo node where u only have 1 subtree, either left or right.
          if (parent == null) {
            if (current.left != null) {
              current.value = current.left.value;
              current.right = current.left.right;
              current.left = current.left.left;
            } else if (current.right != null) {
              current.value = current.right.value;
              current.left = current.right.left;
              current.right = current.right.right;
            }
            return;
          }

          // parent is not null , but 1 subtree is.
          if (parent.left == current) {
            parent.left = current.left != null ? current.left : current.right;
          } else if (parent.right == current) {
            parent.right = current.left != null ? current.left : current.right;
          }
          break;
        }
      }
    }

    private int getMinValue() {
      if (left == null) return value;
      return left.getMinValue();
    }
  }
}
