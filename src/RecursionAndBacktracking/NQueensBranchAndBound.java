package RecursionAndBacktracking;
import java.util.Scanner;
public class NQueensBranchAndBound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [][] board = new boolean[n][n];
        boolean [] cols = new boolean[n];
        boolean [] normalDiagonal = new boolean[2*n-1];
        boolean [] reverseDiagonal = new boolean[2*n-1];

        nQueens(board, 0, cols, normalDiagonal, reverseDiagonal);
    }

    private static void nQueens(boolean [][] board, int row, boolean [] cols, boolean [] normalDiagonal, boolean [] reverseDiagonal){
        if(row==board.length){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    if(board[i][j]==false) {
                        System.out.print("0"+" ");
                    }
                    else{
                        System.out.print("1"+" ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int col=0;col<board.length;col++){
            if(cols[col]==false && normalDiagonal[row+col]==false && reverseDiagonal[row-col+ board.length -1]==false){
                board[row][col] = true;
                cols[col] = true;
                normalDiagonal[row+col] = true;
                reverseDiagonal[row-col+ board.length -1] = true;
                nQueens(board,row+1,cols,normalDiagonal, reverseDiagonal);
                board[row][col] = false;
                cols[col] = false;
                normalDiagonal[row+col] = false;
                reverseDiagonal[row-col+ board.length -1] = false;
            }
        }
    }

}
