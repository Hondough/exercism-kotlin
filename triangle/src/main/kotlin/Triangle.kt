class Triangle (val a: Double, val b: Double, val c: Double) {
    constructor (a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    init {
        require(a + b + c != 0.0)
        require(a + b > c && b + c > a)
    }

    val isEquilateral = a == b && a == c

    val isIsosceles = a == b || a == c || b == c

    val isScalene = !isIsosceles
}