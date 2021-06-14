package RecursionAndBacktracking;
import java.util.Scanner;

public class PrintMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        printMazePath(1,1,m,n,"");
    }

    private static void printMazePath(int sr, int sc, int dr, int dc, String ans){
        if(sr==dr && sc==dc){
            System.out.println(ans);
            return;
        }
        // Horizontal
        if(sc < dc){
            printMazePath(sr, sc+1, dr, dc, ans+"H");
        }
        //Vertical
        if(sr < dr){
            printMazePath(sr+1, sc, dr, dc, ans+"V");
        }
    }
}
