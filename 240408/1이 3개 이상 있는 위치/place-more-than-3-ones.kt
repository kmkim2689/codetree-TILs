import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var count = 0

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val grid = List(n) {
        br.readLine().trim().split(" ").map { it.toInt() }
    }

    val directions = listOf(
        Position(1, 0),
        Position(0, 1),
        Position(0, -1),
        Position(-1, 0)
    )

    for (i in 0 until n) {
        for (j in 0 until n) {
            val position = Position(i, j)
            var curr = 0
            directions.forEach {
                val searchPosition = position + it
                if (searchPosition.x in 0 until n
                    && searchPosition.y in 0 until n
                    && grid[searchPosition.x][searchPosition.y] == 1) {
                    curr++
                }
            }
            if (curr >= 3) count++
        }
    }
    println(count)
}

data class Position(
    val x: Int = 0,
    val y: Int = 0
) {
    operator fun plus(other: Position): Position {
        return Position(
            this.x + other.x,
            this.y + other.y
        )
    }
}

/*
북 동 남 서 => 0 1 2 3
Position(1, 0)
Position(0, 1)
Position(0, -1)
Position(-1, 0)
*/