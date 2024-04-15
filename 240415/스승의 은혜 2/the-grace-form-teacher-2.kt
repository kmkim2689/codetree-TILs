val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, b) = br.readLine().trim().split(" ").map(String::toInt)
    val prices = List(n) { br.readLine().toInt() }
    var count = 0
    var left = b
    val sortedPrice = prices.sorted()
    loop@ for (i in 0 until n) {
        if (left - sortedPrice[i] >= 0) {
            left -= sortedPrice[i] 
            count++
        } else {
            val newLeftPrice = left - sortedPrice[i] / 2
            if (newLeftPrice >= 0) {
                count++
            }
            break@loop
        } 
    }   
    println(count)
}