package RecursionAndBacktracking;
import java.util.Scanner;
/*
Input:
5 4
0 0 0 1
0 1 0 0
0 0 0 1
1 1 0 0
0 0 0 0

Output:
DDRRDDR
DDRRDRD
RRDDDDR
RRDDDRD
 */
public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] arr = new int[m][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        boolean [][] visited = new boolean[m][n];
        floodFill(arr,0,0,m-1,n-1,"",visited);
    }

    private static void floodFill(int [][] arr,int sr, int sc, int dr, int dc, String ans, boolean [][] visited){
        if(sr<0 || sc<0 || sr>dr || sc>dc || arr[sr][sc]==1 || visited[sr][sc]==true){
            return;
        }

        if(sr==dr && sc==dc){
            System.out.println(ans);
            return;
        }

        visited[sr][sc] = true;
        floodFill(arr, sr-1, sc, dr, dc, ans+"T",visited);
        floodFill(arr, sr, sc-1, dr, dc, ans+"L",visited);
        floodFill(arr, sr+1, sc, dr, dc, ans+"D",visited);
        floodFill(arr, sr, sc+1, dr, dc, ans+"R",visited);
        visited[sr][sc] = false;
    }
}
