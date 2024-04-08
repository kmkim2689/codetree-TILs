import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().trim().split(" ").map { it.toInt() }
    val grid: MutableList<MutableList<Int>> = MutableList(n) { MutableList(m) { 0 } }
    var position = Position()
    val directions = listOf(
        Position(0, 1),
        Position(1, 0),
        Position(0, -1),
        Position(-1, 0)
    )
    var curr = 1
    var direction = 0

    while (curr <= n * m) {
        grid[position.r][position.c] = curr
        curr++
        val next = position + directions[direction]
        if (next.r in 0 until n && next.c in 0 until m && grid[next.r][next.c] == 0) {
            position = next
        } else {
            direction = (direction + 1) % 4
            position = position + directions[direction]
        }
    }

    grid.forEach {
        it.forEach { num ->
            print("${num} ")
        }
        println()
    }
}

data class Position(
    val r: Int = 0,
    val c: Int = 0
) {
    operator fun plus(other: Position): Position {
        return Position(this.r + other.r, this.c + other.c)
    }
}

/*
e s w n
Position(1, 0),
Position(0, -1),
Position(-1, 0),
Position(-1, 0)
*/