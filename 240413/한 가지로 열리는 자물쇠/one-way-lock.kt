import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (a, b, c) = br.readLine().trim().split(" ").map(String::toInt)
    var count = 0
    for (i in 1..n) {
        for (j in 1..n) {
            for (k in 1..n) {
                if (abs(i - a) <= 2 || abs(j - b) <= 2 || abs(k - c) <= 2) {
                    count++
                }
            }
        }
    }

    println(count)
}