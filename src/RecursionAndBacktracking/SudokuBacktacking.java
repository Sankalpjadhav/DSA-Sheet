package RecursionAndBacktracking;
import java.util.Scanner;
public class SudokuBacktacking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] board = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = sc.nextInt();
            }
        }
        solveSudoku(board, 0, 0);
    }

    private static void solveSudoku(int [][] board, int i, int j){
        if(i== board.length){
            display(board);
            return;
        }

        int nextI = 0;
        int nextJ = 0;
        if(j==board[0].length-1){
            nextI = i+1;
            nextJ = 0;
        }
        else{
            nextI = i;
            nextJ = j+1;
        }

        if(board[i][j] != 0){
            solveSudoku(board, nextI, nextJ);
        }
        else{

            for(int option=1;option<=9;option++){
                if(isValid(board, i, j, option)== true){
                    board[i][j] = option;
                    solveSudoku(board, nextI, nextJ);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean isValid(int [][] board, int x, int y, int option){

        for(int j=0;j < board[0].length;j++){
            if(board[x][j] == option){
                return false;
            }
        }

        for(int i=0;i < board.length;i++){
            if(board[i][y] == option){
                return false;
            }
        }
        int subMatrixCornerI = (x/3)*3;
        int subMatrixCornerJ = (y/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[subMatrixCornerI+i][subMatrixCornerJ+j]==option){
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(int [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
