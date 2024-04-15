val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val positions = List(n) { 
        val (x, y) = br.readLine().trim().split(" ").map(String::toInt)
        Position(x, y)
    }
    var minValue = Int.MAX_VALUE
    positions.forEachIndexed { index, elem ->
        val remains = positions.toMutableList()
        remains.removeAt(index)
        val maxX = remains.map(Position::x).max()
        val minX = remains.map(Position::x).min()
        val maxY = remains.map(Position::y).max()
        val minY = remains.map(Position::y).min()
        val curr = (maxX!! - minX!!) * (maxY!! - minY!!)
        if (minValue > curr) minValue = curr
    }

    println(minValue)
}

data class Position(val x: Int, val y: Int)