import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val deque = ArrayDeque<Int>()

    for(i in 1.. n) {
        val cmd = sc.next()
        when(cmd) {
            "push_front" -> { 
                deque.addFirst(sc.nextInt())
             }
            "push_back" -> { 
                deque.addLast(sc.nextInt())
             }
            "pop_front" -> { 
                println(deque.pollFirst())
             }
            "pop_back" -> { 
                println(deque.pollLast())
             }
            "size" -> { 
                println(deque.size)
             }
            "empty" -> { 
                if(deque.isEmpty()) {
                    println(1)
                }else{
                    println(0)
                }
             }
            "front" -> { 
                println(deque.peekFirst())
             }
            "back" -> { 
                println(deque.peekLast())
             }
        }
    }
}