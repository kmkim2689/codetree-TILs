import java.util.*
import java.io.*

fun main() {
    val sc = Scanner(System.`in`)
    val input = sc.nextLine().split(" ")
    
    val n = input[0].toInt()
    val t = input[1].toInt()
    val numbers = sc.nextLine().split(" ")

    if (numbers.size == 0){
        println(0)
        return
    }

    val numberList = numbers.map { it.toInt() }

    var count = 0
    var max = 0
    numberList.forEach {
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