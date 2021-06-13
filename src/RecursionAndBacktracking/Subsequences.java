package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;
public class Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> result = getSubsequences(str);
        System.out.println("Subsequences of a given string are :"+result);
    }

    private static ArrayList<String> getSubsequences(String str){
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        char firstChar = str.charAt(0);
        String remainingString = str.substring(1);

        ArrayList<String> resultOfRemainString = getSubsequences(remainingString);

        ArrayList<String> result = new ArrayList<String>();

        for(String s:resultOfRemainString){
            result.add(""+s);
        }

        for(String s:resultOfRemainString){
            result.add(firstChar+s);
        }

        return result;
    }
}
