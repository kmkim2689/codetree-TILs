import java.util.*

val sc = Scanner(System.`in`)

val N = sc.nextInt() // node
val M = sc.nextInt() // edge

var ans = 0

val matrix = Array(N) {
    IntArray(N) { 0 }
}
val visited = BooleanArray(N) { false }

fun dfs(nowNode: Int) {
    for(adj in 0 .. N-1) {
        if(matrix[nowNode][adj] == 1 && !visited[adj]) {
            ans++
            visited[adj] = true
            dfs(adj)
        }
    }

}

fun main() {
    // init matrix
    for(i in 0 .. M-1) {
        val row = sc.nextInt() - 1
        val col = sc.nextInt() - 1

        matrix[row][col] = 1
        matrix[col][row] = 1
    }

    visited[0] = true
    dfs(0)

   println(ans)
}