import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val seq = IntArray(n) { sc.nextInt() }
val dp = IntArray(n) { -1 }

fun main() {    

    dp[0] = 0
    
    for(i in 1 .. n-1) {
        for(j in 0 .. i-1){
            if(dp[j] == -1) continue

            if(j + seq[j] >= i) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    var result = 0

    for(i in 1 .. n-1) {
        result = max(result, dp[i])
    }

    println(result)
}