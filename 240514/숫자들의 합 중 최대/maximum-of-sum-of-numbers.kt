fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (x, y) = br.readLine().trim().split(" ").map(String::toInt)
    var maxValue = Int.MIN_VALUE
    for (i in x..y) {
        val str = i.toString()
        var sum = 0
        str.forEach {
            val number = it.toString().toInt()
            sum += number
        }
        if (sum > maxValue) maxValue = sum
    }
    
    bw.write(maxValue.toString())
    bw.close()
}