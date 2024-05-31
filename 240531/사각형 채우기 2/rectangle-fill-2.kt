import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val MOD = 10_007

fun main() {
    if(n == 1) {
        println(1)
        return
    }
    if(n == 2) {
        println(3)
        return
    }

    val dp = IntArray(n + 1) { 0 }

    dp[1] = 1
    dp[2] = 3

    for(i in 3 .. n) {
        dp[i] = (dp[i-2] * 2 + dp[i-1] ) % MOD
    }

    println(dp[n])
}