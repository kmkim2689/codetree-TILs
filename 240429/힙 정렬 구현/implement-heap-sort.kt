import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt() // 6
    val arr = IntArray(n+1) { 0 } // 5 2 6 1 3 8
    for(i in 1 .. n) {
        arr[i] = sc.nextInt() 
    }

    heapSort(arr, n)

    for(i in 1 .. n) {
        print("${arr[i]} ")
    }
}

fun heapSort(arr: IntArray, n: Int) {
    // make max-heap
    for(i in n / 2 downTo 1) {
        heapify(arr, n, i)
    }

    for (i in n downTo 2) {
        swap(arr, 1, i)
        heapify(arr, i-1, 1)
    }
}

// n: 크기. i: heapify 를 시작하는 인덱스
fun heapify(arr: IntArray, n: Int, i: Int) {
    var largestIdx = i
    var l = 2 * i     // 왼쪽 자식 값
    var r = 2 * i + 1 // 오른쪽 자식 값

    // 왼쪽, 오른쪽 자식값이 크면 largestIdx 변경
    if(l <= n && arr[l] > arr[largestIdx]) {
        largestIdx = l
    }

    if(r <= n && arr[r] > arr[largestIdx]) {
        largestIdx = r
    }

    if(largestIdx != i) {
        swap(arr, i, largestIdx)
        heapify(arr, n, largestIdx)
    }
}

fun swap(arr: IntArray, x: Int, y: Int) {
    val temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp
}