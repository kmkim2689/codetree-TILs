val bw = System.out.bufferedWriter()
var maxValue = 0
lateinit var numbers: List<Int>
var curr = mutableListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    numbers = br.readLine().trim().split(" ").map(String::toInt).sorted()
    backtracking(1, m)
    bw.write(maxValue.toString())
    bw.close()
}

fun backtracking(currSize: Int, maxSize: Int) {
    if (currSize == maxSize + 1) {
        val total = curr.reduce { total, num ->
            total xor num
        }
        if (total > maxValue) maxValue = total
        return
    }

    numbers.forEach {
        if (it !in curr && it > curr.lastOrNull() ?: -1) {
            curr.add(it)
            backtracking(currSize + 1, maxSize)
            curr.removeAt(curr.size - 1)
        }
    }
}