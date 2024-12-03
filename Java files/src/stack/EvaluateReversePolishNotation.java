package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evaluated(String[] tokens){

        Set<String> chars = new HashSet<>();
        chars.add("+");
        chars.add("-");
        chars.add("*");
        chars.add("/");

        Stack<Integer> stack = new Stack<>();
        int res;
        int n2,n1;

        for(String s : tokens){

            if(chars.contains(s)){
                switch (s){

                    case "+":
                        res =stack.pop() + stack.pop();
                        stack.push(res);
                        break;

                    case "-":
                        n1 = stack.pop();
                        n2 = stack.pop();
                        // for the correct order execution(for - and /)
                        res = n2 - n1;
                        stack.push(res);
                        break;

                    case "*":
                        res = stack.pop() * stack.pop();
                        stack.push(res);
                        break;

                    case "/":
                        n1 = stack.pop();
                        n2 = stack.pop();
                        // for the correct order execution(for - and /)
                        res = n2 / n1;
                        stack.push(res);
                        break;
                }
            }else{
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();

    }

    public static void main(String[] args){

        String[] s = {"2","1","+","3","*"};
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evaluated(s));


    }
}
