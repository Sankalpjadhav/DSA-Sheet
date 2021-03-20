package Arrays;
import java.util.Scanner;
/*
Sort an array of 0s, 1s and 2s
Time complexity: O(n)
Space complexity: O(1)
Sample Input:
8
2 1 0 1 2 0 1 2
Sample Output:
0 0 1 1 1 2 2 2
 */
public class SortArrayOf012 {
    private static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void sort(int [] array){
        int i = 0;
        int j = 0;
        int k = array.length-1;
        while(i<=k){
            if(array[i]==0){
                swap(array, i, j);
                j++;
                i++;
            }
            else if(array[i]==2){
                swap(array, i, k);
                k--;
            }else {
                i++;
            }
        }

        //Print the contents
        for(int l=0;l<array.length;l++){
            System.out.print(array[l]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i = 0;i<n;i++){
            array[i] = sc.nextInt();
        }
        sort(array);
    }
}
