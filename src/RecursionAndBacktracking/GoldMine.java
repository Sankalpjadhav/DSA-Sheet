package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;
public class GoldMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] mine = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mine[i][j] = sc.nextInt();
            }
        }
        goldMine(mine);
    }

    private static void goldMine(int [][] mine){
        int maxGold = Integer.MIN_VALUE;
        boolean [][] visited = new boolean[mine.length][mine[0].length];
        for(int i=0;i<mine.length;i++){
            for(int j=0;j<mine[0].length;j++){
                if(mine[i][j]!=0 && visited[i][j]==false) {
                    ArrayList<Integer> bag = new ArrayList<>();
                    collectGold(mine, i, j, visited, bag);
                    int sum = 0;
                    for (int gold : bag) {
                        sum += gold;
                    }

                    maxGold = Math.max(maxGold, sum);
                }
            }
        }
        System.out.println("Maximum gold that can be collected : "+maxGold);
    }

    private static void collectGold(int [][]mine, int i, int j, boolean [][] visited, ArrayList<Integer> bag){
        if(i<0 || j<0 || i>=mine.length || j>=mine[0].length || mine[i][j]==0 || visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        bag.add(mine[i][j]);
        collectGold(mine, i-1, j, visited, bag);
        collectGold(mine, i, j-1, visited, bag);
        collectGold(mine, i+1, j, visited, bag);
        collectGold(mine, i, j+1, visited, bag);
    }
}
