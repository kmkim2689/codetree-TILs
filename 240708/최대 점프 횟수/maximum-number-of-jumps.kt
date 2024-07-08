import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()

val seq = IntArray(n) { sc.nextInt() }
val dp = IntArray(n) { Int.MIN_VALUE }

fun main() {
    dp[0] = 0

    for(i in 0 .. n-2) {
        if(seq[i] == Int.MIN_VALUE) continue

        val endIndex = min(n-1, i + seq[i])

        for(j in i + 1 .. endIndex) {
            dp[j] = max(dp[i] + 1, dp[j])
        }
    }

    var ans = 0
    for(item in dp) {
        ans = max(ans, item)
    }

    println(ans)
}