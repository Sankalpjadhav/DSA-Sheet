package RecursionAndBacktracking;
import java.util.Scanner;
public class JosephusProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println("The person which survives: "+josephusProblem(n,k));
    }

    private static int josephusProblem(int n, int k){
        if(n==1){
            return 0;
        }

        int x = josephusProblem(n-1, k);
        int y = (x + k) % n;

        return y;
    }
}
