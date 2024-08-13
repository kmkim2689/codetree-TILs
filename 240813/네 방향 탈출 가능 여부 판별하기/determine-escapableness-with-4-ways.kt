import java.util.Queue
import java.util.LinkedList

private lateinit var grid: List<List<Int>>
private lateinit var visited: List<MutableList<Boolean>>
private val queue: Queue<Position> = LinkedList()
private val dx = listOf(1, 0, -1, 0)
private val dy = listOf(0, 1, 0, -1)
private var possible: Boolean = false

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    grid = List(n) { br.readLine().trim().split(" ").map(String::toInt) }
    visited = List(n) { MutableList(m) { false } }
    queue.add(Position(0, 0))
    bfs(0, 0)
    if (possible) println(1) else println(0)
}

private fun bfs(x: Int, y: Int) {
    while (queue.isEmpty() == false) {
        val position = queue.poll()
        visited[position.x][position.y] = true
        if (position.x == grid.size - 1 && position.y == grid.first().size - 1) {
            possible = true
            break
        }
        for (i in 0 until 4) {
            val nx = position.x + dx[i]
            val ny = position.y + dy[i]
            if (available(nx, ny)) {
                queue.add(Position(nx, ny))
            }
        }
    }
}

private fun available(x: Int, y: Int): Boolean {
    if (x !in 0 until grid.size || y !in 0 until grid.first().size) return false
    if (visited[x][y] || grid[x][y] != 1) return false
    return true
}

data class Position(
    val x: Int,
    val y: Int
)