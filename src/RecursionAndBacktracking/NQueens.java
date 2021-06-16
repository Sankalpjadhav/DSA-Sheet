package RecursionAndBacktracking;
import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        nQueens(arr, "", 0);
    }

    private static void nQueens(int[][] arr, String answer, int row){
        if(row==arr.length){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int col=0;col<arr.length;col++){
            if(isQueenSafe(arr, row, col)){
                arr[row][col]=1;
                nQueens(arr, answer+row+"-"+col+" ",row+1);
                arr[row][col]=0;
            }
        }
    }

    private static boolean isQueenSafe(int [][] arr, int row, int col){
        /*
        We need to check for directions
        1. Vertical
        2. Left diagonal
        3. Right diagonal
        */

        // Verical
        for(int i=row,j=col;i>=0;i--){
            if(arr[i][j]==1){
                return false;
            }
        }
        // Left diagonal
        for(int i=row,j=col;i>=0 && j>=0 ;i--,j--){
            if(arr[i][j]==1){
                return false;
            }
        }
        // Right diagonal
        for(int i=row,j=col;i>=0 && j<arr.length;i--,j++){
            if(arr[i][j]==1){
                return false;
            }
        }

        return true;
    }
}
