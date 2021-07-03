package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        getMinimumSubsetSumDifference(arr, 0, new ArrayList<Integer>(), new ArrayList<Integer>(), 0, 0);
        System.out.println("Minimum subset sum difference: "+sets);
    }

    static String sets ="";
    static int min = Integer.MAX_VALUE;

    private static void getMinimumSubsetSumDifference(int [] arr, int index, ArrayList<Integer> set1, ArrayList<Integer> set2, int sumOfSet1, int sumOfSet2){
        if(index== arr.length){
            int delta = Math.abs(sumOfSet1 - sumOfSet2);
            if(delta < min){
                min = delta;
                sets = set1+" "+set2;
            }
            return;
        }

        if(set1.size() < (arr.length+1)/2){ // This will make sure elements are equally divided into 2 sets. lets say we have 7 elems, set1 or set2 will include 1 extra elem.
            set1.add(arr[index]);
            getMinimumSubsetSumDifference(arr, index+1, set1, set2, sumOfSet1+arr[index], sumOfSet2);
            set1.remove(set1.size()-1);
        }

        if(set2.size() < (arr.length+1)/2){
            set2.add(arr[index]);
            getMinimumSubsetSumDifference(arr, index+1, set1, set2, sumOfSet1, sumOfSet2+arr[index]);
            set2.remove(set2.size()-1);
        }
    }


}
