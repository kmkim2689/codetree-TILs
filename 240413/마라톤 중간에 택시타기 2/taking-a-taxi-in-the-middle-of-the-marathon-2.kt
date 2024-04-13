import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val positions: List<Position> = List(n) { 
        val (x, y) = br.readLine().trim().split(" ").map(String::toInt)
        Position(x, y)
    }
    var minValue = Int.MAX_VALUE

    for (i in 1 until positions.size - 1) {
        val newPositions = positions.filterIndexed { index, position -> index != i }
        var curr = 0
        for (j in 0 until newPositions.size - 1) {
            curr += newPositions[j].getDistance(newPositions[j + 1])
        }
        if (curr < minValue) minValue = curr
    }

    println(minValue)
}

data class Position(
    val x: Int,
    val y: Int
)

fun Position.getDistance(other: Position): Int = 
    (abs(this.x - other.x) + abs(this.y - other.y))