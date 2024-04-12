import java.io.BufferedReader
import java.io.InputStreamReader

const val EMPTY = ' '

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map(String::toInt)
    val directions = listOf(
        Position(0, 1), // 동
        Position(1, 0), // 남
        Position(0, -1), // 서
        Position(-1, 0) // 북
    )
    var curr = 'A'
    val grid: List<MutableList<Char>> = List(n) { MutableList(m) { EMPTY } }
    var position = Position()
    val rangeR = 0 until n
    val rangeC = 0 until m
    var direction = 0
    while (position.r in rangeR && position.c in rangeC && grid[position.r][position.c] == EMPTY) {
        grid[position.r][position.c] = curr
        if (curr != 'Z') curr++ else curr = 'A'
        val newPosition = position + directions[direction]
        position = if (newPosition.r in rangeR && newPosition.c in rangeC && grid[newPosition.r][newPosition.c] == EMPTY) {
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
    val r: Int = 0,
    val c: Int = 0
) {
    operator fun plus(other: Position): Position {
        return Position(
            this.r + other.r,
            this.c + other.c
        )
    }
}