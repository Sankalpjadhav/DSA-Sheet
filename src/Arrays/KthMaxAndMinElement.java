package Arrays;
import java.util.Scanner;
/*
Kth Maximum and Minimum element in an array.
Time Complexity: O(n)
Space complexity: O(1)
 */
public class KthMaxAndMinElement {
    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int [] arr, int low, int high, int pivot){
        int i = low;
        int j = low;
        while(i <= high){
            if(arr[i] > pivot){
                i++;
            }
            else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        return j-1;
    }

    private static int quickSelect(int [] arr, int low, int high, int k){
        int pivot = arr[high];
        int pivotIndex = partition(arr, low, high, pivot);

        if(pivotIndex < k){
            return quickSelect(arr, pivotIndex+1, high, k);
        }
        else if(pivotIndex > k){
            return quickSelect(arr, low, pivotIndex-1, k);
        }
        else{
            return arr[pivotIndex];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int kthMinimumElem = quickSelect(arr, 0, n-1, k-1);
        int kthMaximumElem = quickSelect(arr, 0, n-1, n-k);
        System.out.println("Kth Minimum element: "+kthMinimumElem);
        System.out.println("Kth Maximum element: "+kthMaximumElem);
        /*
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        */
    }
}
