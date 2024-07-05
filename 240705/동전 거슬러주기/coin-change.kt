import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val m = sc.nextInt()

val coins = IntArray(n) { sc.nextInt() }
val dp = IntArray(m + 1) {Int.MAX_VALUE}

fun main() {

    dp[0] = 0

    for (i in 1 .. m) {
        for(j in 0 .. n-1) {
            if(i >= coins[j]) {
                if(dp[i - coins[j]] == Int.MAX_VALUE) continue

                dp[i] = min(dp[i], dp[i - coins[j]] + 1)
            }
        }
    }
    
    var ans = dp[m]
    if(ans == Int.MAX_VALUE) {
        ans = -1
    }

    println(ans)
}