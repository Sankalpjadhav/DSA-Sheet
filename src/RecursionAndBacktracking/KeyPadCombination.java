package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;
public class KeyPadCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> combinations = getKeyPadCombinations(str);
        System.out.println(combinations);
    }

    static String [] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    private static ArrayList<String> getKeyPadCombinations(String str){
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char firstKey = str.charAt(0);
        String remainingKeys = str.substring(1);

        ArrayList<String> remainingKeysResult = getKeyPadCombinations(remainingKeys);

        ArrayList<String> result = new ArrayList<>();
        String first = codes[firstKey-'0'];
        for(int i=0;i<first.length();i++){
            char ch = first.charAt(i);
            for(String s : remainingKeysResult){
                result.add(ch+s);
            }
        }

        return result;
    }

}
