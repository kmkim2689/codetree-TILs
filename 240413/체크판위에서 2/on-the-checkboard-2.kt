import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().trim().split(" ").map(String::toInt)
    val grid = List(r) { br.readLine().trim().split(" ") }
    val start = grid[0][0]
    var count = 0
    for (i in 1 until r - 2) {
        for (j in 1 until c - 2) {
            if (start != grid[i][j]) {
                val curr = grid[i][j]
                for (k in i + 1 until r - 1) {
                    for (l in j + 1 until c - 1) {
                        if (grid[k][l] == start) count++
                    }
                }
            }
        }
    }

    // edge case : 시작과 끝이 같은 경우, 경로 자체가 성립 불가능
    if (grid[0][0] == grid[r - 1][c - 1]) count = 0
    println(count)
}