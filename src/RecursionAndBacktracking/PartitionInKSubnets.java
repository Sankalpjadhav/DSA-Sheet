package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;
public class PartitionInKSubnets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i =0;i<k;i++){
            arr.add(new ArrayList<>());
        }
        partitionInKSubnets(1, n, k, 0, arr); // // 0 represents number of empty sets occupied
    }

    private static void partitionInKSubnets(int element, int n, int k, int numberOfSets, ArrayList<ArrayList<Integer>> arr){
        if(element > n){
            if(numberOfSets==k){
                for(ArrayList<Integer> set : arr){
                    System.out.print(set+" ");
                }
                System.out.println();
            }
            return;
        }

        for(int j=0;j< arr.size();j++){
            if(arr.get(j).size()>0){
                arr.get(j).add(element);
                partitionInKSubnets(element+1, n, k, numberOfSets, arr);
                arr.get(j).remove(arr.get(j).size()-1);
            }
            else{
                arr.get(j).add(element);
                partitionInKSubnets(element+1, n, k, numberOfSets+1, arr);
                arr.get(j).remove(arr.get(j).size()-1);
                break;
            }
        }

    }
}
