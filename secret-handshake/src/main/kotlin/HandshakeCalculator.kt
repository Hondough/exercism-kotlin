fun Signal.isInHandshake(hs: Int) = mask == (mask and hs)

class HandshakeCalculator() {
    companion object {
        val folder: (List<Signal>, Signal) -> List<Signal> = 
        { acc, signal -> if (signal == Signal.REVERSE) acc.reversed() else acc + signal }

        fun calculateHandshake(hs: Int) =
            Signal.values().filter { it.isInHandshake(hs) } .fold (listOf<Signal>(), folder)
    }
}