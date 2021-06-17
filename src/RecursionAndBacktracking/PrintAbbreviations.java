package RecursionAndBacktracking;
import java.util.Scanner;
public class PrintAbbreviations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printAbbreviations(str, "", 0, 0);
    }

    private static void printAbbreviations(String str, String answerSoFar, int count, int pos)
    {
        if(pos==str.length()){
            if(count==0){
                System.out.println(answerSoFar);
            }
            else{
                System.out.println(answerSoFar+count);
            }
            return;
        }

        if(count>0) {
            printAbbreviations(str, answerSoFar + count + str.charAt(pos), 0, pos + 1);
        }
        else{
            printAbbreviations(str, answerSoFar + str.charAt(pos), 0, pos + 1);
        }
        printAbbreviations(str, answerSoFar, count+1, pos+1);
    }
}
