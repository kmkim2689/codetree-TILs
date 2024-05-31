import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val dp = Array(n) { IntArray(n) { sc.nextInt() } } // 0 ~ n-1

fun main() {
    for(r in 0 .. n-1) {
        for(c in 0 .. n-1) {
            when {
                (r == 0 && c == 0) -> { }
                (r == 0) -> { 
                    dp[r][c] = dp[r][c] + dp[r][c-1]
                }
                (c == 0) -> { 
                    dp[r][c] = dp[r][c] + dp[r-1][c]
                }
                else -> { 
                    dp[r][c] = max(
                        dp[r][c] + dp[r-1][c],
                        dp[r][c] + dp[r][c-1]
                    )
                }
            }
        }
    }
    println(dp[n-1][n-1])
}