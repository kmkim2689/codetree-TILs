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
            var left = b
            var person = 0
            loop@ for (i in 0..count) {
                if (left - items[i].p - items[i].s >= 0) {
                    person++
                    left -= (items[i].p + items[i].s)
                } else {
                    if (left - items[i].p / 2 - items[i].s >= 0) {
                        person++
                    }
                    break@loop
                }
            }
            result.add(person)
        }
    }

    write(result.max().toString())
    close()
}

data class Present(
    val p: Int,
    val s: Int
)