package RecursionAndBacktracking;

import java.util.HashSet;
import java.util.Scanner;
public class WordBreakProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<n;i++){
            set.add(sc.next());
        }
        String sentence = sc.next();
        wordBreakProblem(sentence, "", set);
    }

    private static void wordBreakProblem(String sentence, String answerSoFar, HashSet<String> set){
        if(sentence.length() == 0){
            System.out.println(answerSoFar);
            return;
        }
        for(int i=0;i<sentence.length();i++){
            String leftPart = sentence.substring(0,i+1);
            if(set.contains(leftPart)){
                String rightPart = sentence.substring(i+1);
                wordBreakProblem(rightPart, answerSoFar+leftPart+" ",set);
            }
        }
    }
}
