import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val k = sc.nextInt()
val queue: Queue<Int> = LinkedList<Int>()
val result = mutableListOf<Int>()

fun main() {
    for(i in 1 .. n) {
        queue.add(i)
    }

    while(!queue.isEmpty()) {
        for(i in 1 until k) {
            queue.add(queue.poll())
        }
        result.add(queue.poll())
    }

    for(item in result){
        print("$item ")
    }
}