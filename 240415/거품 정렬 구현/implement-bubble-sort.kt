val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt).toMutableList()

    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] > numbers[i + 1]) {
                sorted = false
                val temp = numbers[i]
                numbers[i] = numbers[i + 1]
                numbers[i + 1] = temp
            }
        }
    }

    numbers.forEach { print("$it ") }
}