import java.util.Queue
import java.util.LinkedList

private lateinit var grid: List<List<Int>>
private lateinit var visited: List<MutableList<Boolean>>
private val queue: Queue<Position> = LinkedList()
private var count = 0
private lateinit var positions: List<Position>
private val dx = listOf(1, 0, -1, 0)
private val dy = listOf(0, 1, 0, -1)

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().trim().split(" ").map(String::toInt)
    grid = List(n) { br.readLine().trim().split(" ").map(String::toInt) }
    visited = List(n) { MutableList(n) { false } }
    positions = List(k) {
        val (r, c) = br.readLine().trim().split(" ").map(String::toInt)
        Position(r - 1, c - 1)
    }
    positions.forEach {
        if (available(it.r, it.c)) {
            visited[it.r][it.c] = true
            count++
            queue.add(it)
            bfs()
        }
    }

    println(count)
}

private fun bfs() {
    while (queue.isNotEmpty()) {
        val position = queue.poll()
        for (i in 0 until 4) {
            val nr = position.r + dx[i]
            val nc = position.c + dy[i]
            if (available(nr, nc)) {
                visited[nr][nc] = true
                count++
                queue.add(Position(nr, nc))
            }
        }
    }
}

private fun available(r: Int, c: Int): Boolean {
    if (r !in 0 until grid.size || c !in 0 until grid.first().size) return false
    if (visited[r][c] == true || grid[r][c] != 0) return false
    return true
}

data class Position(
    val r: Int,
    val c: Int
)