val bw = System.out.bufferedWriter()
private lateinit var grid: List<List<Int>>
private var maxValue = Int.MIN_VALUE
private val currNumbers = mutableListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    grid = List(n) {
        br.readLine().trim().split(" ").map(String::toInt)
    }
    backtracking(1, n)
    bw.write(maxValue.toString())
    bw.close()
}

fun backtracking(curr: Int, max: Int) {
    if (curr == max + 1) {
        var currMin = Int.MAX_VALUE
        for (i in 0 until max) {
            val num = grid[i][currNumbers[i]]
            if (num < currMin) currMin = num
        }
        if (currMin > maxValue) maxValue = currMin
        return
    }

    for (i in 0 until max) {
        if (i !in currNumbers) {
            currNumbers.add(i)
            backtracking(curr + 1, max)
            currNumbers.removeAt(currNumbers.size - 1)
        }
    }
}