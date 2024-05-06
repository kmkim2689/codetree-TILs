private val bw = System.out.bufferedWriter()
private var curr = mutableListOf<Range>()
private var ranges = mutableListOf<Range>()
private var maxCount = 1 // 선분이 하나라면 반드시 겹치지 않기 때문

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    repeat(n) {
        val (start, end) = br.readLine().trim().split(" ").map(String::toInt)
        ranges.add(Range(start, end))
    }
    ranges = ranges.sortedBy { it.start }.toMutableList()
    backtracking(1, n)
    bw.write(maxCount.toString())
    bw.close()
}

private fun backtracking(currSize: Int, maxSize: Int) {
    determine()
    if (currSize == maxSize + 1) {
        return
    }

    ranges.forEach {
        if (currSize == 1) {
            curr.add(it)
            backtracking(currSize + 1, maxSize)
            curr.removeAt(curr.size - 1)
        } else {
            if (curr.last().end < it.start) {
                curr.add(it)
                backtracking(currSize + 1, maxSize)
                curr.removeAt(curr.size - 1)
            }
        }
    }
}

private fun determine() {
    if (curr.size > maxCount) {
        maxCount = curr.size
    }
}

data class Range(
    val start: Int, 
    val end: Int
)