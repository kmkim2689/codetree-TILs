import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[][] dp = new int[n][n];

    public static void main(String[] args) {
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                dp[r][c] = sc.nextInt();
            }
        }
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++){
                if(c == 0 & r == 0) {
                    
                }else if(c == 0) {
                    dp[r][c] = dp[r][c] + dp[r-1][c];
                }else if(r == 0) {
                    dp[r][c] = dp[r][c] + dp[r][c-1];
                }else {
                    dp[r][c] = Math.max(dp[r][c] + dp[r][c-1], dp[r][c] + dp[r-1][c]);
                }
            }
        }        
        System.out.println(dp[n-1][n-1]);
    }
}