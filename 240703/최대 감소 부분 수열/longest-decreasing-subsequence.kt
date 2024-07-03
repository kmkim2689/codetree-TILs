import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val seq = IntArray(n+1) { 0 }
val dp = IntArray(n+1) { 0 }

fun main(){

    for(i in  1 .. n) {
        seq[i] = sc.nextInt()
    }
    
    dp[1] = 1
    for(i in 2 .. n) {
        var maxDp = 0
        for(j in i downTo 1){
            if(seq[i] < seq[j]) {
                maxDp = max(maxDp, dp[j])
            }
        }
        dp[i] = maxDp + 1
    }
    var result = 1
    for(i in 1 .. n) {
        result = max(result, dp[i])
    }
    println(result)
}