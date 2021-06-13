package RecursionAndBacktracking;
import java.util.Scanner;
public class PrintSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printSubsequences(str,"");
    }

    private static void printSubsequences(String str, String answer){
        if(str.length()==0){
            System.out.println(answer);
            return;
        }
        char first = str.charAt(0);
        String restOfTheString = str.substring(1);
        printSubsequences(restOfTheString, answer+"");
        printSubsequences(restOfTheString, answer+first);

    }
}
