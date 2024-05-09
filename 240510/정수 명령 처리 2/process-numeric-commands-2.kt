import java.util.*



fun main(){

    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val queue: Queue<Int> = LinkedList<Int>()

    for(i in 1 .. n){
        val cmd = sc.next()
        when(cmd) {
            "push" -> {
                val item = sc.nextInt()
                queue.add(item)
            }
            "front" -> {
                println(queue.peek())
            }
            "size" -> {
                println(queue.size)
            }
            "empty" -> {
                if(queue.isEmpty()) {
                    println(1)
                }else {
                    println(0)
                }
            }
            "pop" -> {
                println(queue.poll())
            }
        }
    }
    
}