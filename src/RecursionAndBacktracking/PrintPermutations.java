package RecursionAndBacktracking;
import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printPermutations(str,"");
    }

    private static void printPermutations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String remainingString = str.substring(0,i)+str.substring(i+1); // Left part + right part
            printPermutations(remainingString, ans+ch);
        }
    }
}