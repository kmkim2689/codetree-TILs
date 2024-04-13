import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val peopleNums = MutableList(n) { br.readLine().toInt() }
    val distances = List(n) { it }
    var minValue = Int.MAX_VALUE

    for (index in 0 until n) {
        var currDist = 0
        val first = peopleNums.first()
        peopleNums.remove(first)
        peopleNums.add(first)
        distances.zip(peopleNums) { dist, num ->
            currDist += (dist * num)
        }
        if (minValue > currDist) minValue = currDist
    }

    println(minValue)
}