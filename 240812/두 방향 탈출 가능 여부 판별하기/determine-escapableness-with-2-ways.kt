private lateinit var grid: List<List<Int>>
private lateinit var visited: MutableList<MutableList<Boolean>>
private var possible: Boolean = false

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map(String::toInt)
    grid = List(n) { br.readLine().split(" ").map(String::toInt) }
    visited = MutableList(n) { MutableList(m) { false } }
    dfs(0, 0)
    if (possible) println(1) else println(0)
}

private fun dfs(x: Int, y: Int) {
    val dx = listOf(0, 1)
    val dy = listOf(1, 0)
    for (i in 0..1) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (available(nx, ny)) {
            if (nx == grid.size - 1 && ny == grid.first().size - 1) {
                possible = true
                return
            }
            visited[nx][ny] = true
            dfs(nx, ny)
        }
    }
}

private fun available(x: Int, y: Int): Boolean {
    if (x !in 0 until grid.size || y !in 0 until grid.first().size) return false
    if (visited[x][y] || grid[x][y] != 1) return false
    return true
}