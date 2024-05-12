val bw = System.out.bufferedWriter()
private lateinit var numbers: List<Int>
private val indexes = arrayListOf<Int>()
private var maxScore = Int.MIN_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k) = br.readLine().trim().split(" ").map(String::toInt)
    numbers = br.readLine().trim().split(" ").map(String::toInt)
    
    backtracking(1, n, k, m)
    bw.write(maxScore.toString())
    bw.close()
}

fun backtracking(currSize: Int, maxSize: Int, numSize: Int, target: Int) {
    if (currSize == maxSize + 1) {
        val scores = MutableList(maxSize) { 1 }
        indexes.zip(numbers) { index, number ->
            scores[index] += number
        }
        val total = scores.count { it >= target }
        if (maxScore < total) maxScore = total
        return
    }

    for (i in 0 until maxSize) {
        indexes.add(i)
        backtracking(currSize + 1, maxSize, numSize, target)
        indexes.removeAt(indexes.size - 1)
    }
}