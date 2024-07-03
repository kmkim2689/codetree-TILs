import java.util.*
import kotlin.math.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val seq = IntArray(n)
    val dp = IntArray(n) { 1 } // 모든 dp 요소를 1로 초기화

    for (i in 0 until n) {
        seq[i] = sc.nextInt()
    }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (seq[i] < seq[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    val result = dp.maxOrNull() ?: 1 // dp 배열의 최댓값이 결과

    println(result)
}