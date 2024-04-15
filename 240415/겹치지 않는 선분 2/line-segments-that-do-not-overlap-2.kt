val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val positions = List(n) {
        val (x1, x2) = br.readLine().trim().split(" ").map(String::toInt)
        Position(x1, x2)
    }
    var count = 0
    for (i in 0 until positions.size - 1) {
        var isPossible = false
        for (j in i + 1 until positions.size) {
            if (positions[i].x1 < positions[j].x1 && positions[i].x2 < positions[j].x2
            || positions[j].x1 < positions[i].x1 && positions[j].x2 < positions[i].x2) {
                isPossible = true
            } else {
                isPossible = false
                break
            }
        }
        if (isPossible) count++
    }

    println(count)
}

data class Position(val x1: Int, val x2: Int)