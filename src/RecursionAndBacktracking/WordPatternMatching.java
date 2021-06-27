package RecursionAndBacktracking;

import java.util.HashMap;
import java.util.Scanner;
/*
mzaddytzaddy
abcb
a->m b->zaddy c->t b->zaddy
a->mz b->addy c->tz b->addy
a->mza b->ddy c->tza b->ddy
a->mzad b->dy c->tzad b->dy
a->mzadd b->y c->tzadd b->y

 */
public class WordPatternMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String pattern = sc.next();
        HashMap<Character, String> map = new HashMap<>();
        solution(str, pattern, map, pattern);
    }

    private static void solution(String str, String pattern, HashMap<Character, String> map, String originalPattern){
        if(pattern.length()==0){
            if(str.length()==0){
                for(int i=0;i<originalPattern.length();i++){
                    char ch = originalPattern.charAt(i);
                    System.out.print(ch+"->"+map.get(ch)+" ");
                }
                System.out.println();
            }
            return;
        }

        char ch = pattern.charAt(0);
        String restOfThePattern = pattern.substring(1);

        if(map.containsKey(ch)){
            String matchedWord = map.get(ch);
            if(matchedWord.length() <= str.length()){
                String left = str.substring(0, matchedWord.length());
                String right = str.substring(matchedWord.length());
                if(matchedWord.equals(left)){
                    solution(right, restOfThePattern, map, originalPattern);
                }
            }
        }
        else{
            for(int i=0;i<str.length();i++){
                String left = str.substring(0,i+1);
                String right = str.substring(i+1);
                map.put(ch, left);
                solution(right, restOfThePattern, map, originalPattern);
                map.remove(ch);
            }
        }
    }
}
