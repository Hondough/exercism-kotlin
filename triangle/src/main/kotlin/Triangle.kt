class Triangle (val x: Number, val y: Number, val z: Number) {

    init {
        val a = x.toDouble()
        val b = y.toDouble()
        val c = z.toDouble()
        require(a + b + c != 0.0)
        require(a + b > c && b + c > a && a + c > b)
    }

    val isEquilateral = x == y && x == z

    val isIsosceles = x == y || x == z || y == z

    val isScalene = !isIsosceles
}