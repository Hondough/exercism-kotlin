class SpaceAge(val seconds: Long) {
    
    val orbitalPeriod = 31557600.0

    fun convert(factor: Double): Double = Math.round(100 * seconds / orbitalPeriod / factor) / 100.0

    fun onEarth() = convert(1.0)
    fun onMercury() = convert(0.2408467)
    fun onVenus() = convert(0.61519726)
    fun onMars() = convert(1.8808158)
    fun onJupiter() = convert(11.862615)
    fun onSaturn() = convert(29.447498)
    fun onUranus() = convert(84.016846)
    fun onNeptune() = convert(164.79132)
}