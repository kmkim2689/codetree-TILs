import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val grid = List(n) { br.readLine().trim().split(" ").map(String::toInt) }
    var maxCount = 0

    for (i in 0 until n) {
        for (j in 0 until n - 2) {
            val count = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]
            if (count > maxCount) maxCount = count
        }
    }

    println(maxCount)
}