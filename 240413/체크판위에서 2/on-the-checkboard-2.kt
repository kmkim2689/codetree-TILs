import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().trim().split(" ").map(String::toInt)
    val grid = List(r) { br.readLine().trim().split(" ") }
    val start = grid[0][0]
    var count = 0
    for (i in 1 until r - 1) {
        for (j in 1 until c - 1) {
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

    println(count)
}