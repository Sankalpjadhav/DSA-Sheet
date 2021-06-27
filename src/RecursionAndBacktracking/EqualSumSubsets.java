package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class EqualSumSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }

        int k = sc.nextInt();
        if(k == 1){
            for(int i=0;i<n;i++) {
                System.out.print("["+arr[i]);
            }
            System.out.println("]");
            return;
        }

        if(k>n || sum%k!=0){
            System.out.print("Not possible.");
            return;
        }
        int [] sumOfSubsets = new int[k];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0;i<k;i++){
            al.add(new ArrayList<>());
        }
        equalSumSubsets(arr, 0, al, sumOfSubsets, 0, k, n);
    }

    private static void equalSumSubsets(int [] arr, int index, ArrayList<ArrayList<Integer>> al, int [] sumOfSubsets, int setFilledSoFar, int k, int n){
        if(index==arr.length){
            if(setFilledSoFar==k){
                boolean flag = true;
                for(int i=0;i< sumOfSubsets.length-1;i++){
                    if(sumOfSubsets[i]!=sumOfSubsets[i+1]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                   for(ArrayList<Integer> arrayList : al ){
                       System.out.print(arrayList);
                   }
                   System.out.println();
                }
            }
            return;
        }

        for(int i=0;i<al.size();i++){
            if(al.get(i).size()>0) { // Existing set
                al.get(i).add(arr[index]);
                sumOfSubsets[i]+=arr[index];
                equalSumSubsets(arr, index+1, al, sumOfSubsets, setFilledSoFar, k, n);
                sumOfSubsets[i]-=arr[index];
                al.get(i).remove(al.get(i).size()-1);
            }
            else{ // Starting a new set
                al.get(i).add(arr[index]);
                sumOfSubsets[i]+=arr[index];
                equalSumSubsets(arr, index+1, al, sumOfSubsets, setFilledSoFar+1, k, n);
                sumOfSubsets[i]-=arr[index];
                al.get(i).remove(al.get(i).size()-1);
                break;
            }
        }
    }
}
