import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val arr = IntArray(n) { sc.nextInt() }
    sort(arr)

    printArray(arr)
}

fun sort(array: IntArray){
    val n = array.size

    for(i in 0 until n) {
        for(j in 0 until n-1) {
            if(array[j] > array[j+1]){
                val temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            }
        }
    }
}

fun printArray(array: IntArray){
    for(item in array){
        print("${item} ")
    }
    println()
}