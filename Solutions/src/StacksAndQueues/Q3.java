package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

class Stack {
    private int capacity;
    public Node top, bottom;
    public int size = 0;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(int value) {
        if (size >= capacity) return false;
        size++;
        Node n = new Node(value);
        if (size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }

    public int pop() {
        if (top == null) throw new EmptyStackException();
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }

    private void join(Node above, Node below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }
}

class Node {
    public Node above, below;
    public int value;

    public Node(int value) {
        this.value = value;
    }
}

class SetOfStacks {
    private ArrayList<Stack> stacks = new ArrayList<>();
    private int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    private Stack getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value) {
        Stack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(value);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int value = last.pop();
        if (last.isEmpty()) stacks.remove(stacks.size() - 1);
        return value;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedItem;
        if (removeTop) {
            removedItem = stack.pop();
        } else {
            removedItem = stack.removeBottom();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removedItem;
    }

    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }
}

public class Q3 {
    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(3); 
        stacks.push(10);
        stacks.push(20);
        stacks.push(30);
        stacks.push(40);
        stacks.push(50);

        System.out.println("Pop: " + stacks.pop()); 
        System.out.println("PopAt(0): " + stacks.popAt(0)); 
        System.out.println("Pop: " + stacks.pop()); 
    }
}
