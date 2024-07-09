import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val m = sc.nextInt()

// 0,0 ~ n-1, m-1 2 dimension array
val arr = Array(n) {
    IntArray(m) {sc.nextInt() }
}

val dp = Array(n) {
    IntArray(m) {Int.MIN_VALUE}
}

fun main(){
    
    dp[0][0] = 1

    for(i in 0 .. n-1) {
        for(j in 0 .. n-1) {
            if(dp[i][j] == Int.MIN_VALUE) continue

            for(newI in i+1 .. n-1) {
                for(newJ in j+1 .. n-1) {
                    if(arr[newI][newJ] > arr[i][j]) {
                        dp[newI][newJ] = max(dp[newI][newJ], dp[i][j] + 1)
                    }
                }
            }
        }
    }
    var ans = 0
    for(i in 0 .. n-1) {
        for(j in 0 .. m-1) {
            ans = max(ans, dp[i][j])
        }
    }

    println(ans)
}