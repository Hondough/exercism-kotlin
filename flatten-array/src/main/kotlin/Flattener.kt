object Flattener {

    fun flatten1(a: List<Any?>): List<Any> {
        val result = ArrayList<Any>()
        for (item in a) {
            when (item) {
                is Int -> result.add(item)
                else -> item?.let { result.addAll(flatten(it as List<Any>)) }
            }
        }
        return result
    }

    fun flatten(a: List<Any?>): List<Any> =
        a.fold(emptyList<Any>()) { acc, i ->
            when (i) {
               is Int? -> i?.let { acc + i } ?: acc
               else -> acc + flatten(i as List<Any>)
            }
        }
}