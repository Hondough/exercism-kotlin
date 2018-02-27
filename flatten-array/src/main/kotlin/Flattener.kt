object Flattener {

    fun flatten(a: List<Any?>): List<Any> =
        a.fold(emptyList<Any>()) { acc, i ->
            when (i) {
               is Int? -> i?.let { acc + i } ?: acc
               else -> acc + flatten(i as List<Any>)
            }
        }
}