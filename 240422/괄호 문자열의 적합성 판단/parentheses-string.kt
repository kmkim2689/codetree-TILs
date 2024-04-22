import java.util.Stack

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val str = br.readLine().trim()
    val isAvailable = isAvailable(str)
    if (isAvailable) println("Yes") else println("No")
}

fun isAvailable(str: String): Boolean {
    val stack = Stack<Char>()
    str.forEach { char ->
        if (char == '(') {
            stack.push('(')
        } else {
            if (stack.isEmpty()) {
                return false
            } else {
                stack.pop()
            }
        }
    }

    return stack.isEmpty()
}