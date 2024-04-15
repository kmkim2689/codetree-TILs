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
    // 완전 탐색하는 세 대상의 인덱스 범위가 같으면 안된다는 법은 없음
    for (i in 0 until positions.size) {
        for (j in 0 until positions.size) {
            for (k in 0 until positions.size) {
                if (i == j || i == k || j == k) continue
                val xItems = listOf(positions[i], positions[j], positions[k]).map(Position::x)
                val yItems = listOf(positions[i], positions[j], positions[k]).map(Position::y)
                if (xItems.size == xItems.distinct().size || yItems.size == yItems.distinct().size) continue
                val curr = abs(xItems.max()!! - xItems.min()!!) * abs(yItems.max()!! - yItems.min()!!)
                if (curr > maxValue) maxValue = curr
                isPossible = true
            }
        }
    }

    if (!isPossible) println(0) else println(maxValue)
}

data class Position(val x: Int, val y: Int)