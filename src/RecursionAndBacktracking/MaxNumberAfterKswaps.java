package RecursionAndBacktracking;
import java.util.Scanner;
/*
Input:
1234567
4
Output:
Max number possible after K Swaps: 7654321
 */
public class MaxNumberAfterKswaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int k = sc.nextInt();
        maximum = number;
        maxNumberPossible(number, k);
        System.out.println("Max number possible after K Swaps: "+maximum);
    }
    static String maximum = "";

    private static void maxNumberPossible(String number, int k){
        if(Integer.parseInt(number) > Integer.parseInt(maximum)){
            maximum = number;
        }

        if(k==0){
            return;
        }

        for(int i=0;i<number.length()-1;i++){
            for(int j=i+1;j<number.length();j++){
                if(number.charAt(j)>number.charAt(i)){
                    number = swap(number, i, j);
                    maxNumberPossible(number, k-1);
                    number = swap(number, i, j);
                }
            }
        }
    }

    private static String swap(String number, int i, int j){
        char ch1 = number.charAt(i);
        char ch2 = number.charAt(j);
        String left = number.substring(0,i);
        String middle = number.substring(i+1,j);
        String right = number.substring(j+1);

        return left+ch2+middle+ch1+right;
    }

}
