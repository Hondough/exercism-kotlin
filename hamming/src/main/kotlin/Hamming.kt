class Hamming {
    companion object {
        fun compute(left: String, right: String) =
            if (left.length != right.length)
                throw IllegalArgumentException("left and right strands must be of equal length.")
            else
                left.zip(right, {l, r -> if (l == r) 0 else 1}).sum()
    }
}