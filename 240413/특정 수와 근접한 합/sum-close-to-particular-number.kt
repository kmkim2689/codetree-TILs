import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = br.readLine().trim().split(" ").map(String::toInt)
    val numbers = br.readLine().trim().split(" ").map(String::toInt)
    var minValue = Int.MAX_VALUE
    for (i in 0 until numbers.size) {
        for (j in (i + 1) until numbers.size) {
            val total = numbers.filterIndexed { index, num -> index != i && index != j }.sum()
            val diff = abs(s - total)
            if (diff < minValue) minValue = diff
        }
    }
    println(minValue)
}