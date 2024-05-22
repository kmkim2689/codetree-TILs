import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static final int MOD = 10_007;

    public static void main(String[] args) {
        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n == 2) {
            System.out.println(3);
            return;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1]+ dp[i-2] * 2) % MOD;
        }
        System.out.println(dp[n]);
    }
}