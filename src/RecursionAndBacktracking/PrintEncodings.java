package RecursionAndBacktracking;
import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  str = sc.next();
        printEncodings(str,"");
    }

    private static void printEncodings(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        else if(str.length()==1){
            char ch = str.charAt(0);
            if(ch=='0'){
                return;
            }
            else{
                int chValue = ch - '0';
                char code = (char)('a'+chValue-1);
                System.out.println(ans+code);
            }
        }
        else{ // Length 2 or more than 2
            char firstCh = str.charAt(0);
            String restOfTheString = str.substring(1);
            if(firstCh == '0'){
                return;
            }
            else{
                int chValue = firstCh - '0';
                char code = (char)('a'+chValue-1);
                printEncodings(restOfTheString, ans+code);
            }

            String first2Ch = str.substring(0,2);
            String rest = str.substring(2);
            int first2ChValue = Integer.parseInt(first2Ch);
            if(first2ChValue <= 26){
                char code = (char)('a'+first2ChValue-1);
                printEncodings(rest,ans+code);
            }
        }
    }
}
