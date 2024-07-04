import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val seq = IntArray(n) { sc.nextInt() }
val dp = IntArray(n) { 0 }

fun main() {
    dp[0] = 0

    for(i in 0 .. n-1) {
        if(kk(i) == -1) {
            break
        }
    }

    val res = Arrays.stream(dp).max().orElse(0)
    println(res)

}

fun kk(i: Int): Int{
    for(j in i + 1 .. i + seq[i]){
        if(dp[j-1] != 0 && dp[j] == 0) {
            return -1
        }

        if(j in 0..n-1){
            dp[j] = dp[i] + 1
        }
    }
    return 0
}