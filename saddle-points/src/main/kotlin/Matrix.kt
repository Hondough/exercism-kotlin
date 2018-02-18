class Matrix(val matrix: List<List<Int>>) {

    val saddlePoints1 =  matrix
            .mapIndexed { rindex, row -> row
                .foldIndexed (setOf<MatrixCoordinate>(), accumulateSaddlePoints(rindex, row)) }
                .flatten()
                .toSet()

    val saddlePoints =  matrix
            .foldIndexed (setOf<MatrixCoordinate>()) { rindex, acc, row ->
                acc + (row.foldIndexed (setOf<MatrixCoordinate>(), accumulateSaddlePoints(rindex, row))) }

    private fun accumulateSaddlePoints(rindex: Int, row: List<Int>): (Int, Set<MatrixCoordinate>, Int) -> Set<MatrixCoordinate> = 
        { cindex, acc, value -> if (isSaddlePoint(value, row, cindex)) acc + MatrixCoordinate(rindex, cindex) else acc }
    private fun isSaddlePoint(value: Int, row: List<Int>, col: Int) = isRowMax(value, row) && isColMin(value, col)
    private fun isRowMax(value: Int, row: List<Int>): Boolean = value == row.max()!!
    private fun isColMin(value: Int, col: Int): Boolean = value == matrix .map { it[col] } .min()!!
}