import java.util.*;

public class NextGreaterElement {
    public int[] greaterElement(int[] nums1, int[] nums2){
        Map<Integer, Integer> num1Idx = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            num1Idx.put(nums1[i],i);

        }
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<nums2.length;i++) {
            int curr = nums2[i];
            while (!stack.isEmpty() && curr > stack.peek()) {

                int val = stack.pop();
                int idx = num1Idx.get(val);
                result[idx] = curr;
            }
            if (num1Idx.containsKey(curr)) {
                stack.push(curr);

            }
        }
        return result;

    }

    public static void main(String[] args){
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] nums1 = {4,1,2};
        int[] nums2 = {2,1,3,4};
        int[] result = nextGreaterElement.greaterElement(nums1,nums2);
        System.out.print("Next greater element: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

}
