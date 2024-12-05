package StacksAndQueues;


public class Q1 {

    public static void main(String[] args) {
        ThreeStackArray stack = new ThreeStackArray(5);
        stack.push(0, 1);
        stack.push(0, 1);
        stack.push(0, 1);
        stack.push(0, 1);
        stack.push(0, 1);
        stack.pop(0);
        stack.push(0, 1);
    }

    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException(String err) {
            super(err);
        }
    }

    public static class FullStackException extends RuntimeException {
        public FullStackException(String err) {
            super(err);
        }
    }

    public static class ThreeStackArray {
        private int numStack = 3;
        private int stackSize;
        private int[] values;
        private int[] sizes;

        public ThreeStackArray(int stackSize) {
            this.stackSize = stackSize;
            values = new int[stackSize * numStack];
            sizes = new int[numStack];
        }

        public void push(int stackNum, int value) throws FullStackException {
            if (isFull(stackNum)) {
                throw new FullStackException("The stack is full");
            }
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) {
                throw new EmptyStackException("The stack is empty");
            }
            int top_index = indexOfTop(stackNum);
            int value = values[top_index];
            sizes[stackNum]--;
            return value;
        }

        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackSize;
            int size = sizes[stackNum];
            return offset + size - 1;
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) {
                throw new EmptyStackException("The stack is empty");
            }
            return values[indexOfTop(stackNum)];
        }

        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        } // Fixed the missing brace here

        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackSize;
        }
    }
}
