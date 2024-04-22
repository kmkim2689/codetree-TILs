import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = IntArray(n){ sc.nextInt() }

    for(i in 1 until n){
        var j = i - 1 // sortedPartIdx
        var key = arr[i]
        while(j >= 0 && key < arr[j]){
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
    
    for(item in arr){
        print("${item} ")
    }
}