package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParanthese {
    public boolean isValid(String s) {

        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {

            // if we encounter closed brackets(order is open brackets after close brackets)
            // so if we encounter a closed bracket that means we already stored their open bracket in stack.
            if (closeToOpen.containsKey(c)) {
                if (stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c); // pushing open brackets
            }


        }
        return true;
    }
    public static void main(String[] args){

        String s = "()[]{}";
        ValidParanthese validParanthese = new ValidParanthese();
        System.out.println(validParanthese.isValid(s));
    }
}
