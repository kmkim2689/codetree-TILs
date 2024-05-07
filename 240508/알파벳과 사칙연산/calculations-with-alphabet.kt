private val alphabets: MutableList<Char> = mutableListOf()
private val operators = mutableListOf<Char>() 
private val bw = System.out.bufferedWriter()
private val numbers = mutableListOf<Int>()
private var maxValue = Int.MIN_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val input = br.readLine().trim()
    if (input.length == 1) {
        maxValue = 4
    } else {
        input.forEach {
        when (it) {
            '-', '+', '*' -> operators.add(it)
            else -> alphabets.add(it)
        }
    }
    val maxSize = alphabets.distinct().size
    backtracking(1, maxSize)
    }
    
    bw.write(maxValue.toString())
    bw.close()
}

fun backtracking(currSize: Int, maxSize: Int) {
    if (currSize == maxSize + 1) {
        computeMaxValue()
        return
    } 

    for (i in 1..4) {
        numbers.add(i)
        backtracking(currSize + 1, maxSize)
        numbers.removeAt(numbers.size - 1)
    }
}

fun computeMaxValue() {
    val distinctChars = alphabets.distinct()
    val dict = mutableMapOf<Char, Int>()
    distinctChars.forEachIndexed { index, char ->
        dict[char] = numbers[index]
    }
    var curr = dict[alphabets.first()]!!
    operators.forEachIndexed { index, op ->
        when (op) {
            '+' -> curr = curr + dict[alphabets[index + 1].toChar()]!!
            '-' -> curr = curr - dict[alphabets[index + 1].toChar()]!!
            '*' -> curr = curr * dict[alphabets[index + 1].toChar()]!!
        }
    }

    if (curr > maxValue) maxValue = curr
}