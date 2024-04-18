val br = System.`in`.bufferedReader()
private lateinit var numbers: MutableList<Int>

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().trim().toInt()
    val input = br.readLine().trim().split(" ").map(String::toInt)
    numbers = MutableList(n + 1) { 0 }.apply {
        for (i in 0 until n) {
            this[i + 1] = input[i]
        }
    }

    for (i in n / 2 downTo 1) {
        heapify(n, i)
    }

    for (i in n downTo 2) {
        val temp = numbers[1]
        numbers[1] = numbers[i]
        numbers[i] = temp
        heapify(i - 1, 1)
    }
    // heapify(n, n / 2)

    write("${numbers.filterIndexed { index, _ -> index != 0 }.joinToString(" ")}")
    close()
}

fun heapify(
    size: Int,
    mid: Int
) {
    var largest = mid
    val child1 = largest * 2
    val child2 = largest * 2 + 1

    if (child1 <= size && numbers[child1] > numbers[largest]) {
        largest = child1
    }

    if (child2 <= size && numbers[child2] > numbers[largest]) {
        largest = child2
    }

    if (mid != largest) {
        val temp = numbers[mid]
        numbers[mid] = numbers[largest]
        numbers[largest] = temp
        heapify(size, largest)
    }
}