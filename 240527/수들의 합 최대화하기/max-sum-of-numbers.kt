val bw = System.out.bufferedWriter()
private lateinit var grid: List<List<Int>>
private val currNumbers = mutableListOf<Int>()
private var maxNumber = Int.MIN_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    grid = List(n) {
        br.readLine().trim().split(" ").map(String::toInt)
    }
    backtracking(1, n)
    bw.write(maxNumber.toString())
    bw.close()
}

fun backtracking(curr: Int, max: Int) {
    if (curr == max + 1) {
        var currValue = 0
        for (i in 0 until max) {
            currValue += grid[i][currNumbers[i]]
        }
        if (currValue > maxNumber) maxNumber = currValue
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