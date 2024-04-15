val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt)
    var numbersByLength = numbers.groupBy { it.toString().length }
    val numbersList = numbersByLength.map { (len, list) ->
        list.toMutableList()
    }
    println(numbersList)
    // numbers = numbers.map { it.padStart(maxLength, '0') }
    // for (pos in maxLength - 1 downTo 0) {
    //     val arr = MutableList(10) { mutableListOf<String>() }
    //     numbers.forEach {
    //         arr[it[pos].toString().toInt()].add(it.toString())
    //     }
    //     numbers = arr.flatten()
    // }
    // numbers.forEach { write("${it.toInt()} ") }
    close()
}