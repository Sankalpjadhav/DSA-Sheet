package RecursionAndBacktracking;
import java.util.Scanner;
public class PrintStairsPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStairsPath(n, "");
    }

    private static void printStairsPath(int n, String answer){
        if(n<0){
            return;
        }
        if(n==0){
            System.out.println(answer);
            return;
        }
        printStairsPath(n-1,answer+"1");
        printStairsPath(n-2,answer+"2");
        printStairsPath(n-3,answer+"3");
    }
}
