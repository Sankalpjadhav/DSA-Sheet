package RecursionAndBacktracking;
import java.util.Scanner;
/*
Input:
+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
4
LONDON
DELHI
ICELAND
ANKARA

Output:
+ L + + + + + + + +
+ O + + + + + + + +
+ N + + + + + + + +
+ D E L H I + + + +
+ O + + + C + + + +
+ N + + + E + + + +
+ + + + + L + + + +
+ + A N K A R A + +
+ + + + + N + + + +
+ + + + + D + + + +
 */
public class CrosswordPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [][] arr = new char[10][10];
        for(int i=0;i<arr.length;i++){
            String str = sc.next();
            arr[i] = str.toCharArray();
        }
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i = 0 ; i  < words.length; i++){
            words[i] = sc.next();
        }

        solveCrosswordPuzzle(arr, words, 0);
    }

    private static void solveCrosswordPuzzle(char [][] arr, String [] words, int wordIndex){
        if(wordIndex==words.length){
            print(arr);
            return;
        }

        String word = words[wordIndex];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                // From a single place we need to check if the word can be placed horizontally as well as vertically
                if(canPlaceWordHorizontally(arr, word, i, j)){
                    boolean [] wePlaced = placeTheWordHorizontally(arr, word, i, j);
                    solveCrosswordPuzzle(arr, words, wordIndex+1);
                    unplaceTheWordHorizontally(arr, word, wePlaced, i, j);
                }

                if(canPlaceWordVertically(arr, word, i, j)){
                    boolean [] wePlaced = placeTheWordVertically(arr, word, i, j);
                    solveCrosswordPuzzle(arr, words, wordIndex+1);
                    unplaceTheWordVertically(arr, word, wePlaced, i, j);
                }

            }
        }
    }
    private static boolean canPlaceWordHorizontally(char [][] arr, String word, int i, int j){
        if(j-1>=0 && arr[i][j-1]!='+'){
            return false;
        }
        else if(j+word.length()<arr.length && arr[i][j+word.length()]!='+'){
            return false;
        }

        for(int h=0;h<word.length();h++){
            if(j+h >= arr.length){
                return false;
            }
            if(arr[i][j+h]=='-' || arr[i][j+h]==word.charAt(h)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    private static boolean canPlaceWordVertically(char [][] arr, String word, int i, int j){
        if(i-1>=0 && arr[i-1][j]!='+'){
            return false;
        }
        else if(i+word.length()<arr[0].length && arr[i+word.length()][j]!='+'){
            return false;
        }

        for(int v=0;v<word.length();v++){
            if(i+v >= arr[0].length){
                return false;
            }
            if(arr[i+v][j]=='-' || arr[i+v][j]==word.charAt(v)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    private static boolean[] placeTheWordHorizontally(char [][] arr, String word, int i, int j){
        boolean [] wePlaced = new boolean[word.length()];
        for(int h=0;h<word.length();h++){
            if(arr[i][j+h]=='-'){
                arr[i][j+h] = word.charAt(h);
                wePlaced[h]=true;
            }
        }
        return wePlaced;
    }

    private static boolean[] placeTheWordVertically(char [][] arr, String word, int i, int j){
        boolean [] wePlaced = new boolean[word.length()];
        for(int v=0;v<word.length();v++){
            if(arr[i+v][j]=='-'){
                arr[i+v][j] = word.charAt(v);
                wePlaced[v]=true;
            }
        }
        return wePlaced;
    }

    private static void unplaceTheWordHorizontally(char [][] arr, String word, boolean [] wePlaced, int i, int j){
        for(int h=0;h<word.length();h++){
            if(wePlaced[h]==true){
                arr[i][j+h] = '-';
            }
        }
    }

    private static void unplaceTheWordVertically(char [][] arr, String word, boolean [] wePlaced, int i, int j){
        for(int v=0;v<word.length();v++){
            if(wePlaced[v]==true){
                arr[i+v][j] = '-';
            }
        }
    }

    private static void print(char [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
