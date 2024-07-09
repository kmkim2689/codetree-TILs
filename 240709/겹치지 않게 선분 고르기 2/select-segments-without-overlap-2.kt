import java.util.*
import kotlin.math.*

// sort acsending with x1
data class Points(val x1: Int, val x2: Int): Comparable<Points> {
    override fun compareTo(other: Points): Int {
        return x1 - other.x1
    }
}

val sc = Scanner(System.`in`)
val n = sc.nextInt()

val lines = Array<Points>(n) {
    Points(
        sc.nextInt(),
        sc.nextInt()
    )
}

val dp = IntArray(1_000) { 1 }

fun main() {
    for(i in 0 .. n-1) {
        for(j in 0 .. i-1) {
            var startOfNow = lines[i].x1
            var endOfBefore = lines[j].x2

            if(startOfNow > endOfBefore) {
                dp[i] = max(dp[i], dp[j] + 1)
            }

        }
    }

    var ans = 0
    for(i in 0 .. n-1) {
        ans = max(dp[i], ans)
    }
    
    println(ans)
}