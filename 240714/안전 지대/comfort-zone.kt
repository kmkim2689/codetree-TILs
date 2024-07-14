import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)

val N = sc.nextInt()
val M = sc.nextInt()
var highest = 0

val grid = Array(N) {
    IntArray(M) {
        val now = sc.nextInt()
        highest = max(now, highest)
        now
    }
}

var visited = Array(N) {
    BooleanArray(M) { false }
}

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

// K 는 비의 높이
fun canGo(r: Int, c: Int, K: Int) : Boolean {
    if(r < 0 || c < 0 || r >= N || c >= M) {
        return false
    }
    if(grid[r][c] <= K) {
        return false
    }
    if(visited[r][c]) {
        return false
    }
    return true
}

fun dfs(r: Int, c: Int, K: Int) {
    visited[r][c] = true

    for(dir in 0 .. 3) {
        val nextR = r + dx[dir]
        val nextC = c + dy[dir]
        if(canGo(nextR, nextC, K)) {
            dfs(nextR, nextC, K)
        }
    }
}

data class Result(
    val K: Int,
    val KCount: Int
)

val ansNum = mutableListOf<Result>()

fun main() {

    for(k in 1 .. highest) {
        var count = 0
        for(r in 0 .. N-1) {
            for (c in 0 .. M-1){
                if(canGo(r, c, k)) {
                    dfs(r, c, k)
                    count++
                }
            }
        }

        visited = Array(N) { BooleanArray(M) { false } }

        ansNum.add(Result(k, count))
    }

    var answer: Result = Result(0, 0)

    for(item in ansNum) {
        if(answer.KCount < item.KCount) {
            answer = item
        }
    }

    println("${answer.K} ${answer.KCount}")

}