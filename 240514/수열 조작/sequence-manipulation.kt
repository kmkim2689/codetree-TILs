import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val deque: ArrayDeque<Int> = ArrayDeque()

fun main() {
    for(i in 1 .. n) {
        deque.addLast(i)
    }
    operate()
    println(deque.pollFirst())
}

fun operate() {
    while(deque.size > 1) {
        deque.pollFirst()
        if(deque.size > 1) {
            deque.addLast(deque.pollFirst())
        }else {
            return
        }
    }
}