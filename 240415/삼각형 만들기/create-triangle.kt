import kotlin.math.abs

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val positions = List(n) { 
        val (x, y) = br.readLine().trim().split(" ").map(String::toInt)
        Position(x, y)
    }
    var maxValue = Int.MIN_VALUE
    var isPossible = false
    for (i in 0 until positions.size - 2) {
        for (j in i + 1 until positions.size - 1) {
            for (k in j + 1 until positions.size) {
                val xItems = listOf(positions[i], positions[j], positions[k]).map(Position::x)
                val yItems = listOf(positions[i], positions[j], positions[k]).map(Position::y)
                if (xItems.size == xItems.distinct().size || yItems.size == yItems.distinct().size) continue
                // val curr = abs(xItems.max()!! - xItems.min()!!) * abs(yItems.max()!! - yItems.min()!!)
                val curr = abs(
                    (positions[i].x * positions[j].y + positions[j].x * positions[k].y + positions[k].x * positions[i].y) - 
                    (positions[j].x * positions[i].y + positions[k].x * positions[j].y + positions[i].x * positions[k].y)
                )
                if (curr > maxValue) maxValue = curr
                isPossible = true
            }
        }
    }

    if (!isPossible) println(0) else println(maxValue)
}

data class Position(val x: Int, val y: Int)