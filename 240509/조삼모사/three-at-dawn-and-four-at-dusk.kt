import kotlin.math.abs

private val bw = System.out.bufferedWriter()
private lateinit var grid: List<List<Int>>
private val tasks = mutableListOf<Int>()
private var minValue = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    grid = List(n) {
        br.readLine().trim().split(" ").map(String::toInt)
    }

    backtracking(1, n)
    bw.write(minValue.toString())
    bw.close()
}

fun backtracking(currSize: Int, maxSize: Int) {
    if (currSize == maxSize + 1) {
        compute(maxSize)
        return
    }

    for (i in 1..maxSize) {
        if (i !in tasks) {
            tasks.add(i)
            backtracking(currSize + 1, maxSize)
            tasks.removeAt(tasks.size - 1)
        }
    }
}

fun compute(maxSize: Int) {
    var count1 = 0
    var count2 = 0
    for (i in 0 until maxSize / 2 - 1) {
        for (j in i until maxSize / 2) {
            count1 += grid[tasks[i] - 1][tasks[j] - 1]
            count1 += grid[tasks[j] - 1][tasks[i] - 1]
        }
    }

    for (i in maxSize / 2 until maxSize - 1) {
        for (j in i until maxSize) {
            count2 += grid[tasks[i] - 1][tasks[j] - 1]
            count2 += grid[tasks[j] - 1][tasks[i] - 1]
        }
    }

    val difference = abs(count1 - count2)
    if (minValue > difference) minValue = difference
}