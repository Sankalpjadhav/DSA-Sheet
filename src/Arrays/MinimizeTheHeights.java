package Arrays;
import java.util.Arrays;
import java.util.Scanner;
/*
https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.
A slight modification of the problem can be found here.
Example 1:
Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as
{3, 3, 6, 8}. The difference between
the largest and the smallest is 8-3 = 5.
Example 2:
Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{6, 12, 9, 13, 17}. The difference between
the largest and the smallest is 17-6 = 11.

Time Complexity: O(nlogn)
Space complexity: 0(1)
 */
public class MinimizeTheHeights {
    private  static int minimize(int [] array, int n, int k){
        Arrays.sort(array);
        int ans = array[n-1] - array[0];
        int smallest = array[0]+k;
        int largest = array[n-1]-k;
        for(int i=0;i<n-1;i++){
            int min = Math.min(smallest,array[i+1]-k);
            int max = Math.max(largest,array[i+1]+k);
            int result = max - min;
            if(result < 0) continue;
            ans = Math.min(ans, result);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println("The possible minimum difference of the height of shortest and longest towers: "+minimize(array, n, k));
    }
}
