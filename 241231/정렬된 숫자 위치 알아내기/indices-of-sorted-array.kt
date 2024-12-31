fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().trim().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt)
    val list = mutableListOf<Num>()

    for (elem in numbers) {
        if (list.isEmpty()) {
            list.add(Num(elem, 1))
        } else {
            var count = 1
            list.forEach { num ->
                if (num.value > elem) {
                    num.order = num.order + 1
                } else {
                    count++
                }
            }
            list.add(Num(elem, count))
        }
    }

    for (elem in list) {
        bw.write("${elem.order} ")
    }
    
    bw.flush()
    bw.close()
}

class Num(
    val value: Int,
    var order: Int,
)
