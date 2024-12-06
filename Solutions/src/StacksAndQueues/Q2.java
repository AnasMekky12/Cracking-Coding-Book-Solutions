package StacksAndQueues;

import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
    }

    public static class MinStack extends Stack<Integer> {
        Stack<Integer> min_stack;

        public MinStack() {
            min_stack = new Stack<Integer>();
        }

        public Integer push(int value) {
            if (value < min()) {
                min_stack.push(value);
            }
            return super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == min()) {
                min_stack.pop();
            }
            return value;
        }

        public int min() {
            if (min_stack.isEmpty()) {
                return Integer.MAX_VALUE; 
            } else {
                return min_stack.peek();
            }
        }
    }
}
