import java.util.*

val sc = Scanner(System.`in`)

val N = sc.nextInt() // node
val M = sc.nextInt() // edge

var ans = 0

val graph = List(N) {
    mutableListOf<Int>()
}

val visited = BooleanArray(N) { false }

fun dfs(nowNode: Int) {
    
    for(adj in graph[nowNode]) {
        if(!visited[adj]){
            ans++
            visited[adj] = true
            dfs(adj)
        }
    }
}

fun main() {
    // init graph
    for(i in 1 .. M) {
        val row = sc.nextInt() - 1
        val col = sc.nextInt() - 1

        graph[row].add(col)
        graph[col].add(row)
    }

    visited[0] = true
    dfs(0)

    println(ans)
}