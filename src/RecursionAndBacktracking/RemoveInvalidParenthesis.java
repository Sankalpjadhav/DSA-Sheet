package RecursionAndBacktracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int noOfInvalidParenthesis = getCount(str);
        HashSet<String> uniqueParenthesis = new HashSet<String>();
        solution(str, noOfInvalidParenthesis, uniqueParenthesis);
    }

    private static int getCount(String str){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                if(stack.size()==0){
                    stack.push(ch);
                }
                else if(stack.peek()==')'){
                    stack.push(ch);
                }
                else if(stack.peek()=='('){
                    stack.pop();
                }

            }
        }
        return stack.size();
    }

    private static void solution(String str, int noOfInvalidParenthesis, HashSet<String> uniqueParenthesis){
        if(noOfInvalidParenthesis==0) {
            int invalidParenthesisNow = getCount(str);
            if (invalidParenthesisNow==0){
                if (!uniqueParenthesis.contains(str)) {
                    System.out.println(str);
                    uniqueParenthesis.add(str);
                }
             }
            return;
        }

        for(int i=0;i<str.length();i++){
            String left = str.substring(0, i); // This will not include i
            String right = str.substring(i+1);
            solution(left+right, noOfInvalidParenthesis-1, uniqueParenthesis);
        }
    }
}
