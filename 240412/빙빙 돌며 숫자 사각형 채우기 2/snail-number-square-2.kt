import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map(String::toInt)
    val rangeR = 0 until n
    val rangeC = 0 until m
    val positions = listOf(
        Position(1, 0),
        Position(0, 1),
        Position(-1, 0),
        Position(0, -1)
    )
    var direction = 0
    var position = Position()
    val grid: List<MutableList<Int>> = List(n) { MutableList(m) { 0 } }
    var cnt = 1

    while (grid[position.r][position.c] == 0) {
        grid[position.r][position.c] = cnt
        cnt++
        val newPosition = position + positions[direction]
        
        position = if (
            newPosition.r in rangeR && newPosition.c in rangeC 
            && grid[newPosition.r][newPosition.c] == 0
        ) {
            newPosition
        } else {
            direction = (direction + 1) % 4
            position + positions[direction]
        }
    }

    grid.forEach { row ->
        row.forEach { item ->print("$item ") }
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

/*
남 -> 동 -> 북 -> 서(반시계방향)
Position(1, 0),
Position(0, 1),
Position(-1, 0),
Position(0, -1)
*/