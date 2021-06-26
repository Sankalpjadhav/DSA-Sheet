package RecursionAndBacktracking;
import java.util.HashMap;
import java.util.Scanner;
public class PalindromicPermutationOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                int oldFrequency = map.get(ch);
                map.put(ch, oldFrequency+1);
            }
            else{
                map.put(ch, 1);
            }
        }

        Character oddChar = null;
        int noOfOddChars = 0;
        int length = 0;
        for(Character ch : map.keySet()){
            int freq = map.get(ch);
            if(freq%2==1){
                oddChar = ch;
                noOfOddChars++;
            }

            map.put(ch, freq/2);
            length += freq/2;
        }
        if(noOfOddChars>1){
            System.out.println("No Palindromic permutations of a given string possible.");
            return;
        }
        palindromicPermutationsOfAString(1, length, map, oddChar, "");
    }

    private static void palindromicPermutationsOfAString(int currentChar, int totalChar, HashMap<Character, Integer> map, Character oddChar, String asf){
        if(currentChar > totalChar){
            String reverse = "";
            for(int i=asf.length()-1;i>=0;i--){
                char ch = asf.charAt(i);
                reverse += ch;
            }
            if(oddChar !=null){
                asf += oddChar;
            }
            asf += reverse;
            System.out.println(asf);
            return;
        }

        for(Character ch: map.keySet()){
            int freq = map.get(ch);
            if(freq>0){
                map.put(ch, freq-1);
                palindromicPermutationsOfAString(currentChar+1, totalChar, map, oddChar, asf+ch);
                map.put(ch, freq); // For backtracking we need to add freq instead of freq+1 because we haven't changed the value of freq.
            }
        }

    }
}
