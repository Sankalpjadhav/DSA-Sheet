package Arrays;
import java.util.Scanner;
/*
Kadane's Algorithm : To find largest contiguous sub-array sum.
Time Complexity : O(n)
Space Complexity : O(1)
Sample Input:
5
1 2 3 -2 5
Sample Output:
Largest contiguous sub-array sum: 9
 */
public class KadanesAlgorithm {
    private static int maxSubArraySum(int [] array){
        int maxSum = array[0];
        int currentSum = array[0];
        for(int i=1;i<array.length;i++){
            if(currentSum>=0){
                currentSum += array[i];
            }
            else{
                currentSum = array[i];
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i = 0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Largest contiguous sub-array sum: "+maxSubArraySum(array));
    }
}
