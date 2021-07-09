package RecursionAndBacktracking;
import java.util.Scanner;
/*
Coins can be used any number of times. There is no restrictions.
Input:
5
2
3
5
6
7
12
Output:
2 2 2 2 2 2
2 2 2 3 3
2 2 2 6
2 2 3 5
2 3 7
2 5 5
3 3 3 3
3 3 6
5 7
6 6
 */
public class CoinChangeProblem2 {
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

    private static void coinChangeProblem(int index, int [] arr, int amountSoFar, int target, String ansSoFar){
        if(index == arr.length){
            if(amountSoFar==target){
                System.out.println(ansSoFar);
            }
            return;
        }

        for(int i=target/arr[index];i>=1;i--){
            String repeat = "";
            for(int j=0;j<i;j++){
                repeat += arr[index]+" ";
            }
            coinChangeProblem(index+1, arr, amountSoFar+arr[index]*i, target, ansSoFar+repeat);
        }
        coinChangeProblem(index+1, arr, amountSoFar, target, ansSoFar); // No Call
    }
}
