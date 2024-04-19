import java.util.*

fun main(){

    val linkedList = LinkedList<Int>()

    val s = Scanner(System.`in`)

    val n = s.nextInt() // 13

    for(i in 1 .. n){
        val cmd = s.next().toString()

        when(cmd){
            "push_front" -> {
                val x = s.nextInt()
                linkedList.addFirst(x)
            }

            "push_back" -> {
                val x = s.nextInt()
                linkedList.addLast(x)
            }
            
            "pop_front" -> println(linkedList.pollFirst())

            "pop_back" -> println(linkedList.pollLast())

            "size" -> println(linkedList.size)

            "empty" -> {
                if(linkedList.isEmpty()){
                    println(1)
                }else{
                    println(0)
                }
            }

            "front" -> println(linkedList[0])

            "back" -> println(linkedList[linkedList.size - 1])

            else -> {}
        }
    }
}