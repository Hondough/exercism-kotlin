import kotlin.coroutines.experimental.buildSequence

object SpiralMatrix {

    fun <T> Sequence<T>.repeat() = buildSequence { while (true) yieldAll(this@repeat) }

    fun repeats(n: Int): Sequence<Int> = generateSequence(Pair(n * 2 - 1, n), { if (it.second > 0) Pair(it.first - 1, it.first / 2) else null }) .map { it.second }



    fun ofSize(n: Int): Array<Int> {
        fun steps(): Sequence<Int> = listOf(1, n, -1, -n).asSequence()

        println("testing")
        println("steps : ${steps().repeat().take(n).toList()}")
        println("zipped : ${repeats(n).zip(steps()).toList()}")
        return emptyArray<Int>()
    }
}