package RecursionAndBacktracking;
import java.util.Scanner;
public class PrintKeyPadCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printKeyPadCombinations(str,"");
    }

    static String [] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    private static void printKeyPadCombinations(String str, String answer){
        if(str.length()==0){
            System.out.println(answer);
            return;
        }

        char first = str.charAt(0);
        String remainingString = str.substring(1);
        String firstString = codes[first-'0'];

        for(int i=0;i<firstString.length();i++){
            char optionChar = firstString.charAt(i);
            printKeyPadCombinations(remainingString,answer+optionChar);
        }
    }
}
