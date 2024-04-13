import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val items = br.readLine().trim().split(" ").map(String::toInt)
    var minValue = Int.MAX_VALUE
    var decided = false
    
    for (i in 0 until items.size) {
        for (j in 0 until items.size) {
            for (k in 0 until items.size) {
                for (l in 0 until items.size) {
                    if (i == j || j == k || k == l || l == i) continue
                    val team1 = items[i] + items[j]
                    val team2 = items[k] + items[l]
                    val team3 = items.sum() - team1 - team2
                    val sumInfo = listOf(team1, team2, team3)
                    val notAvailable = sumInfo.size != sumInfo.distinct().size
                    if (notAvailable) continue
                    val diff = sumInfo.max()!! - sumInfo.min()!!
                    if (minValue > diff) minValue = diff
                    decided = true
                }
            }
        }
    }

    if (decided) println(minValue) else println(-1)
}