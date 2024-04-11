import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val range = 0 until n
    val directions = listOf(
        Position(1, 0), // 북
        Position(0, 1), // 동
        Position(-1, 0), // 남
        Position(0, -1) // 서
    )
    val grid = List(n) {
        br.readLine().map { it }
    }

    val k = br.readLine().toInt()
    val quotient = (k - 1) / n
    val remainder = (k - 1) % n

    val r = when (quotient) {
        0, 2 -> quotient
        1 -> remainder
        3 -> n - remainder - 1
        else -> throw Exception()
    }

    val c = when (quotient) {
        0 -> remainder
        1 -> n - 1
        2 -> n - remainder - 1
        3 -> 0
        else -> throw Exception()
    }

    var position = Position(r, c)
    var count = 0
    var direction = quotient

    var diff = when {
        quotient == 0 && grid[position.r][position.c] == '/' -> -1
        quotient == 0 && grid[position.r][position.c] == '\\' -> 1
        quotient == 1 && grid[position.r][position.c] == '/' -> 1
        quotient == 1 && grid[position.r][position.c] == '\\' -> -1
        quotient == 2 && grid[position.r][position.c] == '/' -> -1
        quotient == 2 && grid[position.r][position.c] == '\\' -> 1
        quotient == 3 && grid[position.r][position.c] == '/' -> 1
        quotient == 3 && grid[position.r][position.c] == '\\' -> -1
        else -> throw Exception()
    }

    while (position.r in range && position.c in range) {
        direction = when (diff) {
            1 -> {
                diff = -1
                (direction + 1) % 4
            }
            -1 -> {
                diff = 1
                (direction - 1 + 4) % 4
            }
            else -> throw Exception() 
        }
        position = position + directions[direction]
        count++
    }

    println(count)
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
}