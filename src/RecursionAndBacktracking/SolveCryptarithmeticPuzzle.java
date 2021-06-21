package RecursionAndBacktracking;
import java.util.HashMap;
import java.util.Scanner;

public class SolveCryptarithmeticPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();

        HashMap<Character, Integer> charIntMap = new HashMap<>();
        boolean [] usedNumbers = new boolean[10];

        String uniqueString = "";

        // For String 1
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(!charIntMap.containsKey(ch)){
                uniqueString+=ch;
                charIntMap.put(ch,-1);
            }
        }

        // For String 2
        for(int i=0;i<str2.length();i++){
            char ch = str2.charAt(i);
            if(!charIntMap.containsKey(ch)){
                uniqueString+=ch;
                charIntMap.put(ch,-1);
            }
        }

        // For String 3
        for(int i=0;i<str3.length();i++){
            char ch = str3.charAt(i);
            if(!charIntMap.containsKey(ch)){
                uniqueString+=ch;
                charIntMap.put(ch,-1);
            }
        }

        solveCryptarithmetic(str1, str2, str3, usedNumbers, charIntMap, uniqueString, 0);
    }

    private static void solveCryptarithmetic(String str1, String str2, String str3, boolean [] usedNumbers, HashMap<Character,Integer> charIntMap, String uniqueString, int index){
        if(index==uniqueString.length()){
            int num1 = getNum(str1, charIntMap);
            int num2 = getNum(str2, charIntMap);
            int num3 = getNum(str3, charIntMap);

            if(num1+num2==num3){
                // In alphabetical order
                for(int i=0;i<26;i++){
                    char ch = (char)('a'+ i);
                    if(charIntMap.containsKey(ch)){
                        System.out.print(ch+"-"+charIntMap.get(ch)+" ");
                    }
                }
                System.out.println();
            }
            return;
        }

        char ch = uniqueString.charAt(index);
        for(int num=0;num<10;num++){
            if(usedNumbers[num]==false){
                usedNumbers[num]=true;
                charIntMap.put(ch, num);
                solveCryptarithmetic(str1, str2, str3, usedNumbers, charIntMap, uniqueString, index+1);
                charIntMap.put(ch, -1);
                usedNumbers[num]=false;
            }
        }
    }

    private static int getNum(String str, HashMap<Character, Integer> charIntMap){
        String result = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            result += charIntMap.get(ch);
        }
        return Integer.parseInt(result);
    }
}
