package RecursionAndBacktracking;
import java.util.Scanner;
/*
Coin can be used at most once.
Input:
5
2
3
5
6
7
12
Output:
2 3 7  : 12
5 7  : 12
*/
public class CoinChangeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        coinChangeProblem(0, arr, 0, target, "");
    }

    private static void coinChangeProblem(int index, int [] arr, int sum, int target, String answerSoFar){
        if(index==arr.length){
            if(sum==target){
                System.out.println(answerSoFar +" : "+sum);
            }
            return;
        }
        coinChangeProblem(index+1, arr, sum+arr[index], target, answerSoFar+arr[index]+" ");
        coinChangeProblem(index+1, arr, sum, target, answerSoFar);
    }
}
