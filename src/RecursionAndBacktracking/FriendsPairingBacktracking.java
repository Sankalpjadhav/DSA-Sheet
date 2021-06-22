package RecursionAndBacktracking;
import java.util.Scanner;
public class FriendsPairingBacktracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [] paired = new boolean[n+1];
        friendsPairing(1, paired, n, "");
    }

    private static void friendsPairing(int index, boolean [] paired, int n, String answerSoFar){
        if(index > n){
            System.out.println(answerSoFar);
            return;
        }
        if(paired[index]==true){
            friendsPairing(index+1, paired, n, answerSoFar);
        }
        else{
            paired[index]=true;
            friendsPairing(index+1, paired, n, answerSoFar+"("+ index +")");
            for(int i=index+1; i<=n;i++){
                if(paired[i]==false){
                    paired[i] = true;
                    friendsPairing(index+1, paired, n, answerSoFar+"("+index+" "+i+")");
                    paired[i] = false;
                }
            }
            paired[index] = false;
        }
    }
}
