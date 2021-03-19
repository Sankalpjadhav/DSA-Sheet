package Arrays;
import java.util.Scanner;
/*
Reverse an array.
Time complexity: O(n)  n is number of elements in an array.
Space complexity: O(1)
 */
public class ReverseAnArray {
    public static void reverse(int [] array){
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        System.out.println("Reversed array: ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        reverse(array);
    }
}
