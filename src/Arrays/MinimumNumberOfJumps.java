package Arrays;
import java.util.Scanner;
/*
Minimum jumps required to move to end of an array
Time complexity: O(n)
Space complexity: O(1)
 */
public class MinimumNumberOfJumps {
    private static int minimumJumps(int [] array){
        Integer [] dp = new Integer[array.length];
        dp[array.length-1] = 0;
        for(int i=array.length-2;i>=0;i--){
            int steps = array[i];
            int minimum = Integer.MAX_VALUE;
            for(int j=1;j<=steps && i+j<array.length;j++){
                if(dp[i+j]!=null && dp[i+j]<minimum){
                    minimum = dp[i+j];
                }
            }
            if(minimum != Integer.MAX_VALUE){
                dp[i]= minimum + 1;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Minimum number of jumps: "+minimumJumps(array));
    }
}
