package RecursionAndBacktracking;
import java.util.Scanner;
public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char source = 'A';
        char destination = 'B';
        char intermediate = 'C';
        towerOfHanoi(n, source, destination, intermediate);
    }

    private static void towerOfHanoi(int n, char source, char destination, char intermediate){
        if(n==0){
            return;
        }

        towerOfHanoi(n-1,source, intermediate, destination);
        System.out.println(n+"[ "+source+" -> "+destination+" ]");
        towerOfHanoi(n-1, intermediate, destination, source);
    }

}
