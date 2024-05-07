import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val stack = Stack<Int>()

    for(i in 0 until n) {
        val cmd = sc.next().toString()
        when(cmd) {
            "push" -> {
                val item = sc.nextInt()
                stack.push(item)
            }
            "pop" -> {
                val item = stack.pop()
                println(item)
            }
            "size" -> {
                println(stack.size)
            }
            "empty" -> {
                if(stack.isEmpty()) println(1) else println(0)
            }
            "top" -> {
                println(stack.peek())
            }
        }
    }
}