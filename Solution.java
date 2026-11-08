public class Solution {

    // Array-based Stack implementation
    static class ArrayStack {
        private int[] stackArray;
        private int top;

        // Initial capacity is 2
        public ArrayStack(int capacity) {
            stackArray = new int[capacity];
            top = -1;
        }

        // Add an element to the stack
        public void push(int value) {
            if (top == stackArray.length - 1) {
                expandCapacity();
            }
            stackArray[++top] = value;
        }

        // Remove and return the top element
        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stackArray[top--];
        }

        // Check whether the stack is empty
        public boolean isEmpty() {
            return top == -1;
        }

        // Return the number of elements
        public int size() {
            return top + 1;
        }

        // Double the array capacity when it becomes full
        private void expandCapacity() {
            int newCapacity = stackArray.length * 2;
            int[] newArray = new int[newCapacity];

            for (int i = 0; i < stackArray.length; i++) {
                newArray[i] = stackArray[i];
            }

            stackArray = newArray;
        }
    }

    // Reverse the complete array using ArrayStack
    public static int[] reverseArray(int[] numbers) {
        ArrayStack stack = new ArrayStack(2);

        // Push all numbers onto the stack
        for (int number : numbers) {
            stack.push(number);
        }

        // Pop elements into a new array
        int[] reversed = new int[numbers.length];

        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = stack.pop();
        }

        return reversed;
    }

    // Bonus: Reverse only the first K elements
    public static int[] reverseFirstK(int[] numbers, int k) {
        if (k < 0 || k > numbers.length) {
            throw new IllegalArgumentException("K must be between 0 and array length");
        }

        ArrayStack stack = new ArrayStack(2);
        int[] result = numbers.clone();

        // Push the first K elements
        for (int i = 0; i < k; i++) {
            stack.push(numbers[i]);
        }

        // Put them back in reverse order
        for (int i = 0; i < k; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

    // Print an array
    public static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.print("Original array: ");
        printArray(numbers);

        int[] reversed = reverseArray(numbers);
        System.out.print("Reversed array: ");
        printArray(reversed);

        int[] bonus = reverseFirstK(numbers, 3);
        System.out.print("First 3 elements reversed: ");
        printArray(bonus);
    }
}
