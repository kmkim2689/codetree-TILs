import kotlin.math.abs

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val positions = List(n) {
        val (x, y) = br.readLine().trim().split(" ").map(String::toInt)
        Position(x, y)
    }
    var minValue = Int.MAX_VALUE
    for (i in 0 until positions.size - 1) {
        for (j in i + 1 until positions.size) {
            val square = positions[i].getSquare(positions[j])
            if (minValue > square) minValue = square
        }
    }

    println(minValue)
}

data class Position(val x: Int, val y: Int)

fun Position.getSquare(other: Position): Int {
    return (abs(this.x - other.x) * abs(this.x - other.x) + abs(this.y - other.y) * abs(this.y - other.y))
}