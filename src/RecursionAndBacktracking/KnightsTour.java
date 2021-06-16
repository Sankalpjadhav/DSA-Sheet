package RecursionAndBacktracking;
import java.util.Scanner;
public class KnightsTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        int row = sc.nextInt();
        int col = sc.nextInt();
        knightsTour(arr, row, col, 1);
    }

    private static void knightsTour(int [][] arr, int row, int col, int move){
        if(row<0 || col<0 || row>=arr.length || col>=arr.length || arr[row][col]>0){
            return;
        }
        else if(move == arr.length*arr.length){
            arr[row][col]=move;
            printBoard(arr);
            arr[row][col] = 0;
            return;
        }

        arr[row][col] = move;
        knightsTour(arr,row-2, col+1, move+1);
        knightsTour(arr,row-1, col+2, move+1);
        knightsTour(arr,row+1, col+2, move+1);
        knightsTour(arr,row+2, col+1, move+1);
        knightsTour(arr,row+2, col-1, move+1);
        knightsTour(arr,row+1, col-2, move+1);
        knightsTour(arr,row-1, col-2, move+1);
        knightsTour(arr,row-2, col-1, move+1);
        arr[row][col] = 0;
    }
    private static void printBoard(int [][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
