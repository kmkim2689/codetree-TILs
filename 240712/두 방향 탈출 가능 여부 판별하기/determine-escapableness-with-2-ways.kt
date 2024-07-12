import java.util.*

val sc = Scanner(System.`in`)

val dx = intArrayOf(0, 1) // idx 0 이면 아래로.
val dy = intArrayOf(1, 0) // idx 1 이면 오른족으로.

val n = sc.nextInt()
val m = sc.nextInt()

var ans = 0

val maze = Array(n) {
    IntArray(m) { sc.nextInt() }
}

val visited = Array(n) {
    BooleanArray(m) { false }
}

fun canGoTo(row: Int, col: Int): Boolean {
    return (row >= 0 && row <= n-1 && col >= 0 && col <= m-1 && !visited[row][col] && maze[row][col] == 1)
}

fun escapeSuccess(row: Int, col: Int): Boolean {
    return (row == n-1 && col == m-1)
}

fun dfs(nowRow: Int, nowCol: Int){
    if(escapeSuccess(nowRow, nowCol)) {
        ans = 1
        return
    }

    for(dir in 0 .. 1) {
        val nextRow = nowRow + dx[dir]
        val nextCol = nowCol + dy[dir]

        if(canGoTo(nextRow, nextCol)) {
            visited[nextRow][nextCol] = true
            dfs(nextRow, nextCol)
        }
    }
}


fun main() {
    visited[0][0] = true
    dfs(0, 0)
    println(ans)
}