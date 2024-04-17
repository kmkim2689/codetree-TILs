val br = System.`in`.bufferedReader()
private lateinit var numbers: MutableList<Int>
private lateinit var sortedNumbers: MutableList<Int>

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().trim().toInt()
    numbers = br.readLine().trim().split(" ").map(String::toInt).toMutableList()
    sortedNumbers = MutableList(n) { 0 }
    mergeSort(numbers, 0, numbers.lastIndex)
    write(numbers.joinToString(" "))
    close()
}

fun mergeSort(
    nums: List<Int>,
    start: Int,
    end: Int
) {
    if (start < end) {
        val mid = (start + end) / 2
        mergeSort(nums, start, mid)
        mergeSort(nums, mid + 1, end)
        merge(nums, start, mid, end)
    }
}

fun merge(
    nums: List<Int>,
    start: Int,
    mid: Int,
    end: Int
) {
    var i = start // first array start idx
    var j = mid + 1 // second array start idx
    var k = start // pivot
    while (i <= mid && j <= end) {
        if (nums[i] <= nums[j]) {
            sortedNumbers[k] = nums[i]
            i++
        } else {
            sortedNumbers[k] = nums[j]
            j++
        }

        k++
    }

    if (i > mid) {
        for (l in j..end) {
            sortedNumbers[k] = numbers[l]
            k++
        }
    } else {
        for (l in i..mid) {
            sortedNumbers[k] = numbers[l]
            k++
        }
    }

    for (t in start..end) {
        numbers[t] = sortedNumbers[t]
    }
}