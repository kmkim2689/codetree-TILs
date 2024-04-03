import java.util.*
import java.io.*

fun main() {
    val sc = Scanner(System.`in`)
    val input = sc.nextLine().split(" ")
    
    val n = input[0].toInt()
    val t = input[1].toInt()
    val numbers = sc.nextLine().split(" ").map { it.toInt() }

    if (numbers.size == 0){
        println(0)
        return
    }

    var count = 0
    var max = 0
    numbers.forEach {
        if (it > t) {
            count++
            if (count > max) max = count
        } else {
            if (count > max) max = count
            count = 0
        }
    }

    println(max)
}