package Arrays;
import java.util.Scanner;
/*
Move all negative elements to one side of the array.
Time complexity: O(n)
Space complexity: O(1)
Sample Input:
5
2 -9 -4 -2 3
Sample Output:
-9 -4 -2 2 3
 */
public class NegativeElementsToOneSide {
    private static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void move(int [] array){
        int i = 0;
        int j = 0;
        while(i<array.length){
            if(array[i]<0){
                swap(array, i, j);
                i++;
                j++;
            }
            else {
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
        move(array);
    }
}
