import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, t) = br.readLine().trim().split(" ").map(String::toInt)
    val commands = br.readLine()
    val grid: List<List<Int>> = List(n) { br.readLine().trim().split(" ").map(String::toInt) }

    val directions = listOf(
        Position(-1, 0),
        Position(0, 1),
        Position(1, 0),
        Position(0, -1)
    )
    var direction = 0
    val range = 0 until n

    var position = Position.from(n)
    var total = grid[position.r][position.c]
    
    commands.forEach { command ->
        when (command) {
            'L' -> direction = (direction - 1 + 4) % 4
            'R' -> direction = (direction + 1) % 4
            'F' -> {
                val newPosition = position + directions[direction]
                if (newPosition.r in range && newPosition.c in range) {
                    position = newPosition
                    total += grid[position.r][position.c]
                }
            }
            else -> throw IllegalArgumentException()
        }
    }

    println(total)
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