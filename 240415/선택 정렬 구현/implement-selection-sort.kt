val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt).toMutableList()
    for (i in 0 until numbers.size - 1) {
        var minIdx = i
        for (j in i + 1 until numbers.size) {
            if (numbers[minIdx] > numbers[j]) {
                minIdx = j
            }
        }
        val temp = numbers[i]
        numbers[i] = numbers[minIdx]
        numbers[minIdx] = temp
    }
    
    numbers.forEach { print("$it ") }
    br.close()
}