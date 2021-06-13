package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;
public class GetStairsPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> paths = getStairsPath(n);
        System.out.println(paths);
    }

    private static ArrayList<String> getStairsPath(int n){
        if(n==0){
            ArrayList<String> basePositive = new ArrayList<String>();
            basePositive.add("");
            return basePositive;
        }
        else if(n<0){
            ArrayList<String> baseNegative = new ArrayList<String>();
            return baseNegative;
        }

        ArrayList<String> paths1 = getStairsPath(n-1);
        ArrayList<String> paths2 = getStairsPath(n-2);
        ArrayList<String> paths3 = getStairsPath(n-3);

        ArrayList<String> paths = new ArrayList<String>();

        for(String path:paths1){
            paths.add("1"+path);
        }
        for(String path:paths2){
            paths.add("2"+path);
        }
        for(String path:paths3){
            paths.add("3"+path);
        }

        return paths;
    }
}
