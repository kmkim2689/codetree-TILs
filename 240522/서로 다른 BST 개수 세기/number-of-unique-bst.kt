import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()

fun main(){
    if(n == 1) {
        println(1)
        return
    }
    if(n == 2) {
        println(2)
        return
    }
    val dp = IntArray(n+1) { 0 }
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2

    for(i in 3 .. n) {
        for(j in 0 .. i-1) {
            dp[i] = dp[i] + dp[j] * dp[i-1-j]
        }
    }

    println(dp[n])
}