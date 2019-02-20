import kotlin.coroutines.experimental.buildSequence

class SpiralMatrix (val spiralMatrix: Array<IntArray>, val position: Position) {

    constructor (n: Int): this(Array(n, { IntArray(n) }), Position.Start())

    fun applyMove(direction: Direction, value: Int): SpiralMatrix = SpiralMatrix (insertValue(direction, value), nextPosition(direction))
   
    fun nextPosition(direction: Direction): Position.RC =
        when (position) {
            is Position.RC ->
                when (direction) {
                    is Direction.Right  -> Position.RC(position.row, position.col + 1)
                    is Direction.Down   -> Position.RC(position.row + 1, position.col)
                    is Direction.Left   -> Position.RC(position.row, position.col - 1)
                    is Direction.Up     -> Position.RC(position.row - 1, position.col)
                }
            is Position.Start -> Position.RC(0,0)
        }
    
    fun insertValue(direction: Direction, value: Int): Array<IntArray> {
        val nextPosition = nextPosition(direction)
        spiralMatrix[nextPosition.row][nextPosition.col] = value
        return spiralMatrix
    }

    sealed class Position {
        class RC(val row: Int, val col: Int): Position()
        class Start(): Position()
    }

    sealed class Direction {
        class Right(): Direction()
        class Down(): Direction()
        class Left(): Direction()
        class Up(): Direction()
    }

    companion object {

        fun <T> Sequence<T>.repeat() = buildSequence { while (true) yieldAll(this@repeat) }
        fun <T> T.repeat(n: Int): Sequence<T> = buildSequence { repeat(n) { yield(this@repeat) } }

        val directions: Sequence<Direction> = listOf(Direction.Right(), Direction.Down(), Direction.Left(), Direction.Up()).asSequence()

        fun repeats(n: Int): Sequence<Int> = 
            generateSequence(Pair(n * 2 - 1, n), { 
                if (it.second > 0) Pair(it.first - 1, it.first / 2) else null 
            }) .map { it.second }

        fun ofSize(n: Int): Array<IntArray> {
    
           val moves: Sequence<Direction> = repeats(n).zip(directions.repeat(), { r, d -> d.repeat(r) }).flatten();

           val finalState = moves.foldIndexed(SpiralMatrix(n), { index, spiralMatrix, direction -> spiralMatrix.applyMove(direction, index + 1) })

           return finalState.spiralMatrix
        }
    }
}