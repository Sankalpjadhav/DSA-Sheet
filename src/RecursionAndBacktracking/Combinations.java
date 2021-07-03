package RecursionAndBacktracking;
import java.util.Scanner;
/*
Input:
4
2
Output:
ii--
i-i-
i--i
-ii-
-i-i
--ii
 */
public class Combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        combinations(1, n, r, "", 0);
    }

    private static void combinations(int currentBox, int totalBoxes, int totalSelections, String answerSoFar, int selected){
        if(currentBox > totalBoxes){
            if(selected==totalSelections){
                System.out.println(answerSoFar);
            }
            return;
        }
        // options : boxes
        combinations(currentBox+1, totalBoxes, totalSelections, answerSoFar+"i", selected+1);// In box -> yes
        combinations(currentBox+1, totalBoxes, totalSelections, answerSoFar+"-", selected); // In box -> No
    }
}
