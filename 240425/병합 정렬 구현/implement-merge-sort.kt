import java.util.*

lateinit var arr: IntArray

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    arr = IntArray(n) { sc.nextInt() }

    mergeSort(0, n-1)

    for(item in arr) {
        print("${item} ")
    }
}

// 재귀 병합
fun mergeSort(lowIdx: Int, largeIdx: Int) {
    if(lowIdx < largeIdx){
        val midIdx = (lowIdx + largeIdx) / 2
        mergeSort(lowIdx, midIdx)
        mergeSort(midIdx + 1, largeIdx)
        merge(lowIdx, midIdx, largeIdx)
    }
}

// 병합
fun merge(lowIdx: Int, midIdx: Int, largeIdx: Int) {
    val newList = mutableListOf<Int>()

    var lIdx = lowIdx
    var rIdx = midIdx + 1

    while(lIdx <= midIdx && rIdx <= largeIdx) {
        if(arr[lIdx] <= arr[rIdx]){
            newList.add(arr[lIdx])
            lIdx++
        }else if (arr[lIdx] > arr[rIdx]){
            newList.add(arr[rIdx])
            rIdx++
        }
    }

    while(lIdx <= midIdx) {
        newList.add(arr[lIdx])
        lIdx++
    }

    while(rIdx <= largeIdx) {
        newList.add(arr[rIdx])
        rIdx++
    }

    var pos = lowIdx
    for(item in newList) {
        arr[pos++] = item
    }
}