import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val grid = List(n) { MutableList(n) { 0 } }
    var position = Position.from(n)
    val range = 0 until n
    val directions = listOf(
        Position(0, 1), // 동
        Position(-1, 0), // 북
        Position(0, -1), // 서
        Position(1, 0) // 남
    )
    var direction = 0
    var curr = 1

    while (position.r in range && position.c in range && grid[position.r][position.c] == 0) {
        grid[position.r][position.c] = curr
        curr++
        val newPosition = position + directions[direction]
        position = if (newPosition.r in range && newPosition.c in range && grid[newPosition.r][newPosition.c] == 0) {
            newPosition
        } else {
            direction = (direction + 1) % 4
            position + directions[direction]
        }
    }

    grid.forEach { row ->
        row.forEach { print("$it ") }
        println()
    }
}

data class Position(
    val r: Int,
    val c: Int
) {
    operator fun plus(other: Position): Position {
        return Position(
            this.r + other.r,
            this.c + other.c
        )
    }

    companion object {
        fun from(size: Int): Position {
            return Position(size / 2, size / 2)
        }
    }
}