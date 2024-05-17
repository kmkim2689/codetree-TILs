import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int n = sc.nextInt();
    static int[] arr = new int[n];
    
    public static void main(String[] args) {
        for(int i = 0; i < n; i ++) {
            arr[i] = -1;
        }
        System.out.println(pibo(n));
    }

    static int pibo(int i) {
        if(i == 1) return 1;
        if(i == 2) return 1;

        if(arr[i-2] == -1) {
            arr[i-2] = pibo(i-2);
        }
        if(arr[i-1] == -1){
            arr[i-1] = pibo(i-1);
        }

        return arr[i-2] + arr[i-1];
    }
}