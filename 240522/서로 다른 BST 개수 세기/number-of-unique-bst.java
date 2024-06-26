import java.util.*;

public class Main { 
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    public static void main(String[] args) {
        if( n == 1 ) {
            System.out.println(1);
            return;
        }

        if( n == 2 ) {
            System.out.println(2);
            return;
        }

        int[] dp = new int[n+1];
        dp[0] = 1; 
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <=n; i++) {
            for(int j = 0; j <= i-1; j++ ) {
                dp[i] = dp[i] + dp[j] * dp[i-1-j];
            }
        }
        System.out.println(dp[n]);
    }
}