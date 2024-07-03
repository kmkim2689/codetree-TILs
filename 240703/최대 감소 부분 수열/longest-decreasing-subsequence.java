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
                if(seq[i] < seq[j]) {
                    maxDp = Math.max(maxDp, dp[j] + 1);
                }
            }
            dp[i] = maxDp;
        }

        int result = 1;
        for(int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }

        
        System.out.println(result);
    }
}