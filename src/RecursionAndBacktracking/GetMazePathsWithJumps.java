package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsWithJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // Row
        int n = sc.nextInt(); // Column
        ArrayList<String> result = getMazePathsWithJumps(1,1,m,n);
        System.out.println(result);
    }

    private static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        ArrayList<String> paths = new ArrayList<String>();
        // Horizontal
        for(int moveSize=1;moveSize<=dc-sc;moveSize++){
            ArrayList<String> hPaths = getMazePathsWithJumps(sr, sc+moveSize, dr, dc);
            for(String path:hPaths){
                paths.add("H"+moveSize+path);
            }
        }
        //Vertical
        for(int moveSize=1;moveSize<=dr-sr;moveSize++){
            ArrayList<String> vPaths = getMazePathsWithJumps(sr+moveSize, sc, dr, dc);
            for(String path:vPaths){
                paths.add("V"+moveSize+path);
            }
        }
        //Diagonal
        for(int moveSize=1;moveSize<=dr-sr && moveSize<=dc-sc;moveSize++){
            ArrayList<String> dPaths = getMazePathsWithJumps(sr+moveSize, sc+moveSize, dr, dc);
            for(String path:dPaths){
                paths.add("D"+moveSize+path);
            }
        }

        return paths;
    }
}
