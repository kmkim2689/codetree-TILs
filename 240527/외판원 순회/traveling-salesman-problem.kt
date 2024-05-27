val bw = System.out.bufferedWriter()
private lateinit var grid: List<List<Int>>
private val currNumbers = mutableListOf<Int>(0)
private var minValue = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    grid = List(n) {
        br.readLine().trim().split(" ").map(String::toInt)
    }
    backtracking(2, n)
    bw.write(minValue.toString())
    bw.close()
}

fun backtracking(curr: Int, max: Int) {
    if (curr == max + 1) {
        var currValue = 0
        var row = 0
        currNumbers.forEachIndexed { i, number ->
            if (i != 0) {
                val positionValue = grid[row][currNumbers[i]]
                if (positionValue == 0) return
                currValue += positionValue
                row = currNumbers[i]
            }
        }
        val positionValue = grid[row][0]
        if (positionValue == 0) return
        currValue += positionValue
        if (currValue < minValue) minValue = currValue
        return
    }

    for (i in 1 until max) {
        if (i !in currNumbers) {
            currNumbers.add(i)
            backtracking(curr + 1, max)
            currNumbers.removeAt(currNumbers.size - 1)
        }
    }
}