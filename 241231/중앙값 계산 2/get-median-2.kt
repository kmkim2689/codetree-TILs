fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt)

    val curr = mutableListOf<Int>()
    for ((index, elem) in numbers.withIndex()) {
        curr.add(elem)
        curr.sort()
        if (index % 2 == 0) {
            bw.write("${curr[index / 2]} ")
        }
    }

    bw.flush()
    bw.close()
}