import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = IntArray(n) {sc.nextInt()}

    // quick sort
    quickSort(arr, 0, n-1)


    for(item in arr) {
        print("$item ")
    }

}

// quickSort
fun quickSort(arr: IntArray, low: Int, high: Int){
    if(low < high){
        val pos = partition(arr, low, high)

        quickSort(arr, low, pos-1)
        quickSort(arr, pos+1, high)
    }
}

fun partition(arr: IntArray, low:Int, high: Int): Int{
    val p = arr[high]

    var r = low // 먼저 오른쪽으로 확인하는 인덱스
    var b = low -1 // 왼쪽에서 따라가는 인덱스

    for(r in low .. high-1){
        if(arr[r] < p){
            b++
            swap(arr, r, b)
        }
    }
    b++
    swap(arr, b, high)
    return b
}

fun swap(arr: IntArray, r: Int, b: Int){
    val temp = arr[r]
    arr[r] = arr[b]
    arr[b] = temp
}