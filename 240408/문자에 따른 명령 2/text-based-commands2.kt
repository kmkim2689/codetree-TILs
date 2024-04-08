import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()

    var direction = 0
    var position = Position()
    val directions = listOf(
        Position(0, 1),
        Position(1, 0),
        Position(0, -1),
        Position(-1, 0)
    )

    input.forEach {
        when (it) {
            'L' -> direction = (direction - 1 + 4) % 4
            'R' -> direction = (direction + 1) % 4
            'F' -> position = position + directions[direction]
        }
    }

    println("${position.x} ${position.y}")
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
북쪽 : 0 Position(0, 1)
동쪽 : 1 Position(1, 0)
남쪽 : 2 Position(0, -1)
서쪽 : 3 Position(-1, 0)
*/