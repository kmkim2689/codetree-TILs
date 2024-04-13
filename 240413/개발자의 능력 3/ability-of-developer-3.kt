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
                // 리스트를 새로 만들기보다는 기존의 합에 나눈 팀의 합을 빼기만 하면 다른 팀의 합을 구할 수 있음
                val diff = abs(team1.sum() - abs(team1.sum() - items.sum()))
                if (minDiff > diff) minDiff = diff
            }
        }
    }

    println(minDiff)
}