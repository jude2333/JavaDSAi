import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MonotonicIncreasingStack {
    public int[] monotonicStack(int[] nums1){

        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse the array
        for (int num : nums1) {
            // increasing stack means top(smaller elements) to bottom(greater elements).
            // While stack is not empty AND bottom of stack is more than the current element
            while (!stack.isEmpty() && stack.peekLast() > num) {

                // Pop the element from the stack
                stack.pollLast(); // pollLast means popping the bottom element
            }
            // Push the current element into the stack
            stack.offerLast(num);
        }

        // Construct the result array from the stack
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pollLast();
        }

        return result;
    }

    public static void main(String[] args){

        int[] nums = {1,3,2,4};
        MonotonicIncreasingStack monotonicIncreasingStack = new MonotonicIncreasingStack();

        int[] result = monotonicIncreasingStack.monotonicStack(nums);
                System.out.print("Monotonic increasing stack: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
