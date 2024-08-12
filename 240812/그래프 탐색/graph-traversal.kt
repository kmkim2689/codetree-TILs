private lateinit var grid: MutableList<MutableList<Int>>
private var count = 0
private lateinit var visited: MutableList<Boolean>

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map(String::toInt)
    grid = MutableList(n + 1) { MutableList(n + 1) { 0 } }
    visited = MutableList(n) { false }
    repeat(m) {
        val (x, y) = br.readLine().split(" ").map(String::toInt)
        grid[x][y] = 1
        grid[y][x] = 1
    }
    dfs(1)

    println(count - 1)
}

fun dfs(vertex: Int) {
    visited[vertex] = true
    count++
    for (i in 1 until grid.size) {
        if (grid[vertex][i] == 1 && !visited[i]) {
            dfs(i)
        }
    }
}