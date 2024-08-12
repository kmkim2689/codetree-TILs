private lateinit var grid: MutableList<MutableList<Int>>

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map(String::toInt)
    grid = MutableList(m) { mutableListOf<Int>() }
    repeat(m) {
        val (x, y) = br.readLine().split(" ").map(String::toInt)
        grid[x].add(y)
    }
    println(grid)
}