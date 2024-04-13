import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val items = br.readLine().trim().split(" ").map(String::toInt)
    var minDiff = Int.MAX_VALUE
    for (i in 0 until items.size - 2) {
        for (j in i + 1 until items.size - 1) {
            for (k in j + 1 until items.size) {
                val team1 = listOf(items[i], items[j], items[k])
                val team2 = (items - team1)
                val diff = abs(team1.sum() - team2.sum())
                if (minDiff > diff) minDiff = diff
            }
        }
    }

    println(minDiff)
}