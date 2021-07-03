package RecursionAndBacktracking;
import java.util.Scanner;
/*
Here we will be placing r items in n boxes
Input :
4
2
Output :
12__
1_2_
1__2
21__
_12_
_1_2
2_1_
_21_
__12
2__1
_2_1
__21
 */
public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        permutations(new int[n], 1, r);
    }

    private static void permutations(int [] boxes, int currentItem, int totalItems){
        if(currentItem>totalItems){
            for(int i=0;i< boxes.length;i++){
                if(boxes[i]==0){
                    System.out.print("_");
                }
                else{
                    System.out.print(boxes[i]);
                }
            }
            System.out.println();
            return;
        }

        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i] = currentItem;
                permutations(boxes, currentItem+1, totalItems);
                boxes[i] = 0;
            }
        }
    }
}
