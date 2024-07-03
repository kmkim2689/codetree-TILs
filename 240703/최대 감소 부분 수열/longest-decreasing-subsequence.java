import java.util.*;
import java.math.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] seq = new int[n+1];
    static int[] dp = new int[n+1];

    public static void main(String[] args) {
        
        for(int i = 1; i <= n; i++) {
            seq[i] = sc.nextInt();
        }

        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            int maxDp = 0;
            for(int j = 1; j < i; j++) {
                if(seq[i] > seq[j]) {
                    maxDp = Math.max(maxDp, dp[j]);
                }
            }
            dp[i] = maxDp + 1;
        }

        int result = 1;
        for(int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }
        
        System.out.println(result);
    }
}

/*
4
  4 2 3 1 // seq
0 1 2 1 3 // dp


*/