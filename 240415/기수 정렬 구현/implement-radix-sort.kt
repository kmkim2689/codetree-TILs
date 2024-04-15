val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    var numbers = br.readLine().trim().split(" ").map(String::toInt)
    for (pos in numbers.first().toString().length - 1 downTo 0) {
        val arr = MutableList(10) { mutableListOf<Int>() }
        numbers.forEach {
            arr[it.toString()[pos].toString().toInt()].add(it)
        }
        numbers = arr.flatten()
    }
    numbers.forEach { write("$it ") }
    close()
}