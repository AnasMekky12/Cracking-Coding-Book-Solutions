package StacksAndQueues;

import java.util.Stack;

public class Q4 {

    public static class MyQueue<T> {
        private Stack<T> stackNewest;
        private Stack<T> stackOldest;

        public MyQueue() {
            stackNewest = new Stack<>();
            stackOldest = new Stack<>();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(T value) {
            stackNewest.push(value);
        }

        private void shiftStacks() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek() {
            shiftStacks();
            if (stackOldest.isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }
            return stackOldest.peek();
        }

        public T remove() {
            shiftStacks();
            if (stackOldest.isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }
            return stackOldest.pop();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("First element (peek): " + queue.peek());
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Next element (peek): " + queue.peek());
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Queue size: " + queue.size());
    }
}
