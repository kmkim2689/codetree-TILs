import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt() // bread count
    val m = sc.nextInt() // cmd count

    val ll = LinkedList<Char>()
    val pw = sc.next()

    for (i in 0 until n) {
        ll.add(pw[i])
    }

    // println(ll)

    val iter = ll.listIterator(ll.size)

    for(i in 0 until m){
        val cmd = sc.next()[0]
        when(cmd){
            'L' -> {
                if(iter.hasPrevious()){
                    iter.previous()
                }
            }
            'R' -> {
                if(iter.hasNext()){
                    iter.next()
                }
            }
            'D' -> {
                if(iter.hasNext()){
                    iter.next()
                    iter.remove()
                }
            }
            'P' -> {
                iter.add(sc.next()[0])
            }
        }
    }
    
    for(item in ll){
        print(item)
    }


}