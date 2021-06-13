package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;
public class GetMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // Row
        int n = sc.nextInt(); // Column
        ArrayList<String> result = getMazePaths(1,1,m,n);
        System.out.println(result);
    }

    private static ArrayList<String> getMazePaths(int sRow, int sColumn, int dRow, int dColumn){
        if(sRow==dRow && sColumn==dColumn){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        ArrayList<String> verticalPaths = new ArrayList<String>();
        ArrayList<String> horizontalPaths = new ArrayList<String>();
        if(sRow<dRow){
             verticalPaths = getMazePaths(sRow+1,sColumn,dRow,dColumn);
        }
        if(sColumn<dColumn){
            horizontalPaths = getMazePaths(sRow,sColumn+1,dRow,dColumn);
        }

        ArrayList<String> result = new ArrayList<String>();

        for(String path: horizontalPaths){
            result.add("H"+path);
        }
        for(String path: verticalPaths){
            result.add("V"+path);
        }

        return result;
    }
}
