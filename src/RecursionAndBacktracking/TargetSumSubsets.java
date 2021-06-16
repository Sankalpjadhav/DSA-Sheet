package RecursionAndBacktracking;
import java.util.Scanner;

public class TargetSumSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        targetSumSubsets(arr,0,"",0,target);
    }

    private static void targetSumSubsets(int [] arr, int index, String answer, int sum, int target){
        if(index==arr.length){
            if(sum==target){
                System.out.println(answer);
            }
            return;
        }

        targetSumSubsets(arr, index+1, answer+arr[index]+" ",sum+arr[index],target);
        targetSumSubsets(arr, index+1, answer, sum, target);
    }
}
