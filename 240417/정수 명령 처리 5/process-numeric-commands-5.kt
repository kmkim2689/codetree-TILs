import java.util.*

fun main(){
    val s = Scanner(System.`in`)

    val n = s.nextInt()

    val arrList = ArrayList<Int>()

    for (i in 1 .. 9){
        val cmd = s.next().toString()

        when(cmd){
            "push_back" -> { arrList.add(s.nextInt()) }
            "pop_back" -> { arrList.removeAt(arrList.size - 1) }
            "get" -> { println(arrList[s.nextInt() - 1]) }
            "size" -> { println(arrList.size) }
            else -> { }
        }
    }
}