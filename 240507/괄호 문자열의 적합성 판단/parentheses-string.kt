import java.util.*;

val sc = Scanner(System.`in`)
val stack = Stack<Char>()

fun main() {
    val str = sc.next()

    if (validBrace(str)) {
        println("Yes")
    } else {
        println("No")
    }
}

fun validBrace(str: String): Boolean {
    for(item in str) {
        when (item) {
            '(' -> {
                stack.push(item)
            }
            ')' -> {
                if(stack.isEmpty()) {
                    return false
                }
                stack.pop()
            }
        }
    }
    if(!stack.isEmpty()) { 
        return false
    }
    return true
}