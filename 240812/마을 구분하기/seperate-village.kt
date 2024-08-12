private lateinit var grid: List<List<Int>>
private lateinit var visited: MutableList<MutableList<Boolean>>
private val result = mutableListOf<Int>()
private var curr = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    grid = List(n) { br.readLine().trim().split(" ").map(String::toInt) }
    visited = MutableList(n) { MutableList(n) { false } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (available(i, j)) {
                visited[i][j] = true
                curr = 1
                dfs(i, j)
                result.add(curr)
            }
        }
    }
    println(result.size)
    result.sorted().forEach { println(it) }
}

private fun dfs(x: Int, y: Int) {
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (available(nx, ny)) {
            curr++
            visited[nx][ny] = true
            dfs(nx, ny)
        }
    }
}

private fun available(x: Int, y: Int): Boolean {
    if (x !in 0 until grid.size || y !in 0 until grid.size) return false
    if (visited[x][y] || grid[x][y] != 1) return false
    return true
}