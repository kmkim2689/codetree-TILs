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
    if (grid[n - 1][m - 1] == 0 || grid[0][0] == 0) {
        possible = false
    } else {
        queue.add(Position(0, 0))
        visited[0][0] = true
        bfs()
    }
    if (possible) println(1) else println(0)
}

private fun bfs() {
    while (queue.isNotEmpty()) {
        val position = queue.poll()
        if (position.x == grid.size - 1 && position.y == grid.first().size - 1) {
            possible = true
            break
        }
        for (i in 0 until 4) {
            val nx = position.x + dx[i]
            val ny = position.y + dy[i]
            if (available(nx, ny)) {
                queue.add(Position(nx, ny))
                // 여기서 true를 해주는 이유는 경로 후보로 추가되었을 때 각 후보들이 순회할 때 다른 후보를 방문하지 못하도록 하기 위함
                visited[nx][ny] = true
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