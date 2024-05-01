val numbers = arrayListOf<Int>()
var count = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    backtracking(1, n)
    println(count)
}

fun backtracking(currSize: Int, maxSize: Int) {
    if (currSize == maxSize + 1) {
        if (isBeautiful()) {
            count++
        }
        return
    }

    for (i in 1..4) {
        numbers.add(i)
        backtracking(currSize + 1, maxSize)
        numbers.removeAt(numbers.size - 1)
    }
}

fun isBeautiful(): Boolean {
    var currNumber = numbers.first()
    var currCount = 1
    val newNumbers = numbers.toMutableList()
    newNumbers.removeAt(0)
    newNumbers.forEach { number ->
        if (number != currNumber) {
            if (currCount % currNumber != 0) {
                return false
            }
            currNumber = number
            currCount = 1
        } else {
            currCount++
        }
    }
    val result = if (currCount % currNumber != 0) false else true
    return result
}