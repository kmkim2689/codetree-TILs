import java.util.*;

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    val stack = Stack<Char>()

    for(item in str) {
        when (item) {
            '(' -> {
                stack.push(item)
            }
            ')' -> {
                if(stack.isEmpty()) {
                    println("No")
                    return
                }

                stack.pop()
            }
        }
    }

    if(!stack.isEmpty()) { 
        println("No")
        return
    }

    println("Yes")
    return 
}