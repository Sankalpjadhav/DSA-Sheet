package RecursionAndBacktracking;
import java.util.HashSet;
import java.util.Scanner;
/*
Input:
aabbbccdde
3
Output:
cde
bde
bce
bcd
ade
ace
acd
abe
abd
abc
 */
public class WordKSelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int k = sc.nextInt();
        HashSet<Character> set = new HashSet<>();
        String uniqueChars = "";
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                uniqueChars+=ch;
            }
        }

        wordKSelection(uniqueChars, k, "", 0, 0);
    }

    private static void wordKSelection(String uniqueChars, int k, String answerSoFar, int currentIndex, int selectionsSoFar){
        if(currentIndex==uniqueChars.length()){
            if(selectionsSoFar == k){
                System.out.println(answerSoFar);
            }
            return;
        }

        char ch = uniqueChars.charAt(currentIndex);
        wordKSelection(uniqueChars, k, answerSoFar+"", currentIndex+1, selectionsSoFar+0); // Char says No
        wordKSelection(uniqueChars, k, answerSoFar+ch, currentIndex+1, selectionsSoFar+1); // Char says Yes
    }
}
