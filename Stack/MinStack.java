package neetcode_150.Stack;

import java.util.Stack;

public class MinStack {

    private static Stack<Integer> stack;
    private static Stack<Integer> minStack;

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        push(2);
        push(5);
        push(4);
        push(6);

        System.out.println("Top Element :"+top());
        System.out.println("Min Element :"+getMin());

        pop();
        System.out.println("Top Element :"+top());
        System.out.println("Min Element :"+getMin());

        push(1);
        push(10);

        System.out.println("Top Element :"+top());
        System.out.println("Min Element :"+getMin());
    }

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
    }

    public static void pop(){
        if(!stack.isEmpty()){
            int poppedElement = stack.pop();
            if(poppedElement == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public static int top(){
        if(!stack.isEmpty()){
            return stack.peek();
        }

        throw new IllegalStateException("Stack is Empty");
    }

    public static int getMin(){
        if(!minStack.isEmpty()){
            return minStack.peek();
        }

        throw new IllegalStateException("MinStack is Empty");
    }
}
