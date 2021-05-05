package algoexpert.stacks;

import java.util.ArrayList;

public class MinMaxStack {

  private ArrayList<Integer> stack = new ArrayList<>();
  private ArrayList<Integer> min = new ArrayList<>();
  private ArrayList<Integer> max = new ArrayList<>();

  public int peek() {
    return stack.get(stack.size() - 1);
  }

  public int pop() {
    min.remove(min.size() - 1);
    max.remove(max.size() - 1);
    return stack.remove(stack.size() - 1);
  }

  public void push(Integer number) {
    if (stack.isEmpty()) {
      stack.add(number);
      min.add(number);
      max.add(number);
      return;
    }

    int currentMin = min.get(min.size() - 1);
    int currentMax = max.get(max.size() - 1);

    int toBePushedToMinStack = number < currentMin ? number : currentMin;
    int toBePushedToMaxStack = number > currentMax ? number : currentMax;

    stack.add(number);
    min.add(toBePushedToMinStack);
    max.add(toBePushedToMaxStack);
  }

  public int getMin() {
    return min.get(min.size() - 1);
  }

  public int getMax() {
    return max.get(max.size() - 1);
  }

  public static void main(String[] args) {}
}
