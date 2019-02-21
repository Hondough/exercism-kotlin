package SpiralMatrix

fun ofSize(n: Int): Array<IntArray> {
    val matrix = Array(n, { IntArray(n) })
    fun fill(v: Int, ru: Int, rd: Int, cl: Int, cr: Int): Unit {
        if (!(ru >= rd || cl >= cr)) {
            var value = v
            (cl until cr).forEach { matrix[ru][it] = value++ }
            (ru + 1 until rd).forEach { matrix[it][cr - 1] = value++ }
            (cr - 2 downTo cl).forEach { matrix[rd - 1][it] = value++ }
            (rd - 2 downTo ru + 1).forEach { matrix[it][cl] = value++ }
            fill(value, ru + 1, rd - 1, cl + 1, cr - 1)
        }
    }
    fill(1, 0, n, 0, n)
    return matrix
}