package RecursionAndBacktracking;

import java.util.HashMap;
import java.util.Scanner;
/*
Input:aabb
Output:
aabb
abab
abba
baab
baba
bbaa
 */
public class PermutationsOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Character [] spots = new Character[str.length()];
        HashMap<Character,Integer> lastOccurence = new HashMap<>();
        for(Character ch : str.toCharArray()){
            lastOccurence.put(ch, -1);
        }
        printPermutations(str, spots, lastOccurence, 0);
    }

    private static void printPermutations(String str, Character [] spots, HashMap<Character, Integer> lastOccurence, int currentSpot){
        if(currentSpot == str.length()){
            for(int i=0;i<spots.length;i++){
                System.out.print(spots[i]);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(currentSpot);
        int lastOccur = lastOccurence.get(ch);

        for(int i=lastOccur+1;i<spots.length;i++){
            if(spots[i]==null) {
                spots[i] = ch;
                lastOccurence.put(ch, i);
                printPermutations(str, spots, lastOccurence, currentSpot + 1);
                lastOccurence.put(ch, lastOccur);
                spots[i] = null;
            }
        }

    }
}
