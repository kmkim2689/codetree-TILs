val numbers = arrayListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val (k, n) = br.readLine().trim().split(" ").map(String::toInt)
    backtracking(1, n, k)
}

fun backtracking(curr: Int, maxSize: Int, maxNumber: Int) {
    if (curr == maxSize + 1) {
        printNumbers(numbers)
        return
    }

    for (i in 1..maxNumber) {
        numbers.add(i)
        backtracking(curr + 1, maxSize, maxNumber)
        numbers.removeAt(numbers.size - 1)
    }
}

fun printNumbers(numbers: ArrayList<Int>) {
    numbers.forEach {
        print("$it ")
    }
    println()
}