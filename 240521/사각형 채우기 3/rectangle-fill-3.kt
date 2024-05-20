import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()

fun main() {
    
    // 동적 프로그래밍 테이블 초기화
    val dp = LongArray(n + 1) { 0 }
    dp[0] = 1
    if (n >= 1) dp[1] = 2

    // 점화식을 사용하여 dp 테이블 채우기
    for (i in 2..n) {
        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 1_000_000_007
    }

    // 결과 출력
    println(dp[n])
}