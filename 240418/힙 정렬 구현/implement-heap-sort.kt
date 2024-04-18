import java.util.*

fun main() {
    val s = Scanner(System.`in`)
    val n = s.nextInt() // 6
    val arr = IntArray(n + 1) { 0 } // 0 ~ 6 (1 ~ 6)

    for (i in 1..n) {
        arr[i] = s.nextInt() // 5 2 6 1 3 8
    }

    fun swap(x: Int, y: Int) {
        val temp1 = arr[x]
        val temp2 = arr[y]
        arr[y] = temp1
        arr[x] = temp2
    }

    fun heapify(size: Int, i: Int) {
        var maxIdx = i
        val l = i * 2
        val r = i * 2 + 1

        if (l <= size && arr[l] >= arr[maxIdx]) {
            maxIdx = l
        }

        if (r <= size && arr[r] >= arr[maxIdx]) {
            maxIdx = r
        }

        if (maxIdx != i) {
            swap(i, maxIdx)
            heapify(size, maxIdx)
        }
    }

    fun fullHepify(i: Int, size: Int) {
        for (j in i downTo 1) {
            heapify(size, j)
        }
    }

    fun heapSort(size: Int, i: Int) {
        fullHepify(i, size)

        for (j in size downTo 2) {
            swap(1, j)
            heapify(j -1, 1)
        }
    }

    heapSort(n, n / 2)

    for(i in 1 .. n){
        print("${arr[i]} ")
    }
}


    /*
    n개의 원소가 주어졌을 때, 힙 정렬을 이용해 n개의 숫자를 오름차순으로 정렬하는 프로그램을 작성해보세요.
    입력 형식
    첫 번째 줄에는 n이 주어집니다.
    두 번째 줄부터 n개의 원소값이 공백을 사이에 두고 주어집니다.
    1 ≤ n ≤ 100,000
    1 ≤ 원소 값 ≤ 100,000
    
    출력 형식
    첫 번째 줄에 오름차순으로 정렬된 이후의 원소 값을 순서대로 공백을 사이에 두고 출력합니다.
    
    입출력 예제
    예제1
    
    입력:
    6
    5 2 6 1 3 8
    
    출력:
    1 2 3 5 6 8
    
    
    
    
    
    
     */