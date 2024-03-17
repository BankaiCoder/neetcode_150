package neetcode_150.Stack;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "{([])}";
        System.out.println(isValidParan(s));
    }   
    
    public static boolean isValidParan(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(st.size() == 0){
                st.push(s.charAt(i));
                continue;
            }

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));

            }

            else{
                if(s.charAt(i) == ')'){
                    if(st.peek() == '(') st.pop();
                    else return false;
                }

                else if(s.charAt(i) == '}'){
                    if(st.peek() == '{') st.pop();
                    else return false;
                }

                else{
                    if(st.peek() == '[') st.pop();
                    else return false;
                }
            }
        }
        if(st.size() == 0){
            return true;
        }

        return false;
    }
}
