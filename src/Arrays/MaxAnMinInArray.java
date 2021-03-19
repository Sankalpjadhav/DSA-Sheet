package Arrays;
import java.util.Scanner;
/*
Maximum and Minimum element in an array.
Time complexity: O(n)  n is number of elements in an array.
Space complexity: O(1)
 */
public class MaxAnMinInArray {
    private static class Pair{
        int max = 0;
        int min = 0;
    }

    private static Pair MaxAndMinElement(int [] array){
        Pair pair = new Pair();
        if(array.length==0){
            return pair;
        }
        if(array.length==1){
            pair.max = array[0];
            pair.min = array[0];
            return pair;
        }

        if(array[0] > array[1]){
            pair.max = array[0];
            pair.min = array[1];
        }
        else if(array[0] < array[1]){
            pair.max = array[1];
            pair.min = array[0];
        }
        else{
            pair.max = array[0];
            pair.min = array[0];
        }

        for(int i=2;i<array.length;i++){
            if(array[i] < pair.min){
                pair.min = array[i];
            }
            else if(array[i] > pair.max){
                pair.max = array[i];
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        Pair result = MaxAndMinElement(array);
        System.out.println("Maximum element: "+result.max);
        System.out.println("Minimum element: "+result.min);
    }
}
