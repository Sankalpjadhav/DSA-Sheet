package Arrays;
import java.util.Scanner;
/*
Partition an array based on Pivot Element.
Such that all elements which are smaller than pivot element comes to the left of the array and greater elements to the right of an array.
Time complexity: O(n)
Space complexity: O(1)

Sample input:
8
7 9 4 8 3 6 2 1
5
Output:
Partitioned array:
4 3 2 1 9 6 7 8
 */
public class PartitionAnArray {
    public static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void partitionArray(int [] array , int pivot){
        int i = 0;
        int j = 0;
        /*
        3 regions are possible
        0 to j-1 : Elements which are Less than or equal to pivot element are situated.
        j to i-1 : Elements which are Greater than to pivot element are situated.
        i to end : unknowns, at the last there will be no unknowns.
         */

        while(i<array.length){
            if(array[i] > pivot){
                i++;
            }
            else { // Less than or equal to
                swap(array, i, j);
                i++;
                j++;
            }
        }
        System.out.println("Partitioned array:");
        for(int k=0;k<array.length;k++){
            System.out.print(array[k]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int pivot = sc.nextInt();
        partitionArray(array, pivot);
    }
}
