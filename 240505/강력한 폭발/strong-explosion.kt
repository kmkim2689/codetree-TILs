val bw = System.out.bufferedWriter()
val directions = listOf(
    listOf(Position(1, 0), Position(2, 0), Position(-1, 0), Position(-2, 0)),
    listOf(Position(1, 0), Position(-1, 0), Position(0, 1), Position(0, -1)),
    listOf(Position(1, -1), Position(-1, -1), Position(1, 1), Position(-1, 1))
)
val currStatus = arrayListOf<Int>()
val answers = arrayListOf<Int>()
private lateinit var grid: List<MutableList<Int>>
private lateinit var mutatedGrid: List<MutableList<Int>>

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    grid = List(n) {
        br.readLine().trim().split(" ").map(String::toInt).toMutableList()
    }
    val gridSize = grid.size
    val maxNum = grid.flatten().count { it == 1 }
    backtracking(1, maxNum, gridSize)
    bw.write("${answers.max()}")
    bw.close()
}

fun backtracking(currSize: Int, maxSize: Int, gridSize: Int) {
    if (currSize == maxSize + 1) {
        answer(gridSize)
        return
    }

    directions.forEachIndexed { index, _ ->
        currStatus.add(index)
        backtracking(currSize + 1, maxSize, gridSize)
        currStatus.removeAt(currStatus.size - 1)
    }
}

fun answer(gridSize: Int) {
    var directionPos = 0
    var count = grid.flatten().count { it == 1 }
    mutatedGrid = grid.map { it.toMutableList() }.toList()
    mutatedGrid.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, item ->
            if (item == 1) {
                val dirs = directions[currStatus[directionPos]]
                dirs.forEach {
                    val pos = Position(rowIndex, colIndex) + it
                    if (inRange(pos, gridSize) && mutatedGrid[pos.row][pos.column] == 0) {
                        mutatedGrid[pos.row][pos.column] = 2
                        count++
                    }
                }
                directionPos++
            }
        }
    }
    answers.add(count)
}

data class Position(
    val row: Int,
    val column: Int
) {
    operator fun plus(other: Position): Position {
        return Position(this.row + other.row , this.column + other.column)
    }
}

fun inRange(position: Position, gridSize: Int): Boolean {
    return position.row in 0 until gridSize && position.column in 0 until gridSize
}