import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val size = sc.nextInt() // size: 6
    val arr = IntArray( size + 1 ) {0} // 5 2 6 1 3 8
    for(i in 1 .. size) {
        arr[i] = sc.nextInt()
    }

    // heapSort
    heapSort(arr, size / 2)

    for(i in 1 .. size){
        print("${arr[i]} ")
    }
}

fun heapSort(arr: IntArray, pos: Int) {
    // make max-heap
    for (i in pos downTo 1) {
        heapify(arr, i, arr.size - 1)
    }
    
    for(i in arr.size-1 downTo 2) {
        swap(arr, 1, i)
        heapify(arr, 1, i-1)
    }
}

fun heapify(arr: IntArray, pos: Int, size: Int) {
    var maxIdx = pos
    val lIdx = pos * 2
    val rIdx = pos * 2 + 1

    if (size >= lIdx && arr[lIdx] >= arr[maxIdx]) {
        maxIdx = lIdx
    }

    if (size >= rIdx && arr[rIdx] >= arr[maxIdx]) {
        maxIdx = rIdx
    }
    if(pos != maxIdx) {
        swap(arr, pos, maxIdx)
        heapify(arr, maxIdx, size)
    }
}

fun swap(arr: IntArray, x: Int, y: Int) {
    val temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp
}