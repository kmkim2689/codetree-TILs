import java.util.Stack

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val stack = Stack<Int>()

    val n = br.readLine().trim().toInt()
    val orders = List(n) {
        val order = br.readLine().trim().split(" ")
        if (order.size == 2) {
            Order(order[0], order[1].toInt())
        } else {
            Order(order[0])
        }
    }
    
    orders.forEach {
        if (it.name == "push" && it.amount != null) {
            stack.push(it.amount)
        }
        if (it.name == "size") {
            write("${stack.size}\n")
        }
        if (it.name == "pop") {
            write("${stack.pop()}\n")
        }
        if (it.name == "empty") {
            val isEmpty = if (stack.empty()) 1 else 0
            write("$isEmpty\n")
        }
        if (it.name == "top") {
            write("${stack.peek()}\n")
        }
    }

    close()
}

data class Order(
    val name: String,
    val amount: Int? = null
)