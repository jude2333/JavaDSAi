package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemp(int[] temp){
        // 73,74,75,71,69,72,76,73 ==> input

        int left = 0;
        int[] res = new int[temp.length+1];
        Stack<Integer> stack = new Stack<>();

        for(int currDay=0;currDay<temp.length;currDay++){
            // if we encounter prevday less than currday, updating out answer
                while(!stack.isEmpty() && temp[currDay] > temp[stack.peek()]){
                    int prevDay = stack.pop();
                    res[prevDay] = currDay - prevDay;
                }

            stack.push(currDay);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args){
        int[] nums = {73,74,75,71,69,72,76,73};
        DailyTemperature dailyTemperature = new DailyTemperature();
        dailyTemperature.dailyTemp(nums);
    }

}
