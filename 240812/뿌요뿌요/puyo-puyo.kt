private lateinit var grid: List<List<Int>>
private lateinit var visited: List<MutableList<Boolean>>
private var result = mutableListOf<Int>()
private var curr = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    grid = List(n) { br.readLine().trim().split(" ").map(String::toInt) }
    visited = List(n) { MutableList(n) { false } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (available(i, j, grid[i][j])) {
                curr = 1
                visited[i][j] = true
                dfs(i, j, grid[i][j])
                result.add(curr)
            }
        }
    }

    val size = result.filter { it >= 4 }.size
    val max = result.max()
    println("$size $max")
}

private fun dfs(x: Int, y: Int, targetNumber: Int) {
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (available(nx, ny, targetNumber)) {
            curr++
            visited[nx][ny] = true
            dfs(nx, ny, targetNumber)
        }
    }
}

private fun available(x: Int, y: Int, targetNumber: Int): Boolean {
    if (x !in 0 until grid.size || y !in 0 until grid.size) return false
    if (visited[x][y] || grid[x][y] != targetNumber) return false
    return true
}