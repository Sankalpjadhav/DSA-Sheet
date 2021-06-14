package RecursionAndBacktracking;
import java.util.Scanner;
public class PrintMazePathsWithJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        printMazePathsWithJumps(1,1,m,n,"");
    }

    private static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String ans){
        if(sc==dc && sr==dr){
            System.out.println(ans);
            return;
        }
        // For horizontal
        for(int move=1;move<=dc-sc;move++){
            printMazePathsWithJumps(sr, sc+move, dr,dc, ans+"H"+move);
        }
        // For Vertical
        for(int move=1;move<=dr-sr;move++){
            printMazePathsWithJumps(sr+move, sc, dr, dc, ans+"V"+move);
        }
        // For Diagonal
        for(int move=1;move<=dr-sr && move<=dc-sc;move++){
            printMazePathsWithJumps(sr+move, sc+move, dr, dc, ans+"D"+move);
        }
    }
}
