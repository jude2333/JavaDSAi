package stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public int top(){
        return stack.peek();
    }

    public void push(int val){
        stack.push(val);

        minStack.push(Math.min(val, minStack.isEmpty() ? val : minStack.peek()));

    }

    public int getMin(){
        return minStack.peek();
    }



    public void pop(){
        stack.pop();
        minStack.pop();
    }

}
