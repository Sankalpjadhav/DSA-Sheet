package RecursionAndBacktracking;
import java.util.Scanner;
// Here you will get a string which is palindrome, from that string, you need to find all the palindromic strings.
/*
Input : abaaba
Output:
(a)(b)(a)(a)(b)(a)
(a)(b)(a)(aba)
(a)(b)(aa)(b)(a)
(a)(baab)(a)
(aba)(a)(b)(a)
(aba)(aba)
(abaaba)
 */
public class PalindromePatitioningOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        palindromePartitioning(str, "");
    }

    private static void palindromePartitioning(String str, String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        for(int i=0;i<str.length();i++){
            String prefix = str.substring(0,i+1);
            String restOfTheString = str.substring(i+1);
            if(isPalindrome(prefix)){
                palindromePartitioning(restOfTheString, asf+"("+prefix+")");
            }
        }
    }

    private static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while (left < right){
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);
            if(leftChar != rightChar){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
