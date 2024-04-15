val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, b) = br.readLine().trim().split(" ").map(String::toInt)
    val items = MutableList(n) {
        val (p, s) = br.readLine().trim().split(" ").map(String::toInt)
        Present(p, s)
    }
    // val sortedItems = items.sortedBy { it.p + it.s }
    var maxValue = Int.MIN_VALUE
    val result = mutableListOf<Int>()

    for (i in 1..n) {
        items.add(items.first())
        items.removeAt(0)
        repeat(n) { count ->
            val newItems = items.slice(0..count)
            var left = b
            var person = 0
            loop@ for (i in 0 until newItems.size) {
                if (left - newItems[i].p - newItems[i].s >= 0) {
                    person++
                    left -= (newItems[i].p + newItems[i].s)
                } else {
                    if (left - newItems[i].p / 2 - newItems[i].s >= 0) {
                        person++
                    }
                    break@loop
                }
            }
            result.add(person)
        }
    }

    println(result.max())
}

data class Present(
    val p: Int,
    val s: Int
)