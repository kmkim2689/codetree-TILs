import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val items = br.readLine().trim().split(" ").map(String::toInt)
    var minValue = Int.MAX_VALUE
    var decided = false
    
    for (i in 0 until items.size - 1) {
        for (j in (i + 1) until items.size) {
            val team1 = listOf(items[i], items[j])
            val newItems = items.filterIndexed { index, _ ->
                index != items.indexOf(items[i]) && index != items.indexOf(items[j])
            }
            for (k in 0 until newItems.size - 1) {
                for (l in (k + 1) until newItems.size) {
                    val team2 = listOf(newItems[k], newItems[l])
                    val teamSumInfo = listOf(team1.sum(), team2.sum(), items.sum() - team1.sum() - team2.sum())
                    val notAvailable = teamSumInfo.size != teamSumInfo.distinct().size
                    if (notAvailable) continue
                    val diff = teamSumInfo.max()!! - teamSumInfo.min()!!
                    if (minValue > diff) minValue = diff
                    decided = true
                }
            }
        }
    }

    if (decided) println(minValue) else println(-1)
}