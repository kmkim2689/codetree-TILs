import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // t : h높이만큼 연속으로 나와야 하는 최소 횟수
    val (n, h, t) = br.readLine().trim().split(" ").map(String::toInt)
    val heights = br.readLine().trim().split(" ").map(String::toInt)
    var minExpense = Int.MAX_VALUE

    for (i in 0..n - t) {
        var expense = 0
        val slicedHeights = heights.slice(i until i + t)
        slicedHeights.forEach {
            expense += abs(it - h)
        }
        if (minExpense > expense) minExpense = expense
    }

    println(minExpense)
}