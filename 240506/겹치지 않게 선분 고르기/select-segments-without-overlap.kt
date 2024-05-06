private val bw = System.out.bufferedWriter()
private val curr = mutableListOf<Range>()
private val ranges = arrayListOf<Range>()
private var maxCount = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    repeat(n) {
        val (start, end) = br.readLine().trim().split(" ").map(String::toInt)
        ranges.add(Range(start, end))
    }
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
        curr.add(it)
        backtracking(currSize + 1, maxSize)
        curr.removeAt(curr.size - 1)
    }
}

private fun determine() {
    var isAvailable = true

    val sortedRanges = curr.sortedBy { it.start }
    for (i in 0 until sortedRanges.size - 1) {
        for (j in i until sortedRanges.size) {
            if (sortedRanges[i].end <= sortedRanges[j].start) {
                return
            }
        }
    }

    if (isAvailable && curr.size > maxCount) {
        maxCount = curr.size
    }
}

data class Range(
    val start: Int, 
    val end: Int
)