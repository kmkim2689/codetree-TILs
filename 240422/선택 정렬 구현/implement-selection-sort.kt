import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = IntArray(n) { sc.nextInt() }

    for(i in 0 until n){
        var minIdx = i
        for (j in i+1 until n-1){
            if(arr[minIdx] > arr[j]){
                minIdx = j
            }
        }
        val temp = arr[i]
        arr[i] = arr[minIdx]
        arr[minIdx] = temp
    }

    for(item in arr){
        print("${item} ")
    }
}