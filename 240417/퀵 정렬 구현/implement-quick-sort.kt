val br = System.`in`.bufferedReader()
private lateinit var numbers: MutableList<Int>

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().trim().toInt()
    numbers = br.readLine().trim().split(" ").map(String::toInt).toMutableList()
    quickSort(0, numbers.lastIndex)
    write(numbers.joinToString(" "))
    close()
}

fun quickSort(
    start: Int,
    end: Int
) {
    if (start < end) {
        val partition = partition(start, end)
        quickSort(start, partition - 1)
        quickSort(partition + 1, end)
    }
}

fun partition(
    start: Int,
    end: Int
): Int {
    val pivot = numbers[end]
    var i = start - 1

    for (j in start until end) {
        if (numbers[j] < pivot) {
            i++
            val temp = numbers[i]
            numbers[i] = numbers[j]
            numbers[j] = temp
        }
    }
    val temp = numbers[i + 1]
    numbers[i + 1] = numbers[end]
    numbers[end] = temp

    return i + 1
}