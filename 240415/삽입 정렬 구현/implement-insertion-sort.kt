val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt).toMutableList()
    for (i in 1 until numbers.size) {
        val key = numbers[i]
        var j = i - 1
        while (j >= 0 && numbers[j] > key) {
            numbers[j + 1] = numbers[j]
            j--
        }
        numbers[j + 1] = key
    }

    numbers.forEach { write("$it ") }
    close()
}